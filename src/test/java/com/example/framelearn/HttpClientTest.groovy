package com.example.framelearn

import com.example.framelearn.groovy.HttpClient
import lombok.extern.slf4j.Slf4j
import spock.lang.Specification



 import com.alibaba.fastjson.JSON
 import org.apache.http.ProtocolVersion
 import org.apache.http.entity.BasicHttpEntity
 import org.apache.http.impl.client.CloseableHttpClient
 import org.apache.http.impl.execchain.HttpResponseProxy
 import org.apache.http.message.BasicHttpResponse
 import org.apache.http.message.BasicStatusLine
 import spock.lang.Specification

 /**
 * Created by shuqin on 18/3/12.
  *
  * Spock Mock 单测就是这样：setup-given-when-then 四步曲。读者可以打断点观察单测的单步运行。
  *
  * 使用Groovy+Spock编写单测的 expect-where , when-then-thrown, setup-given-when-then[-where]
  * 三种最常见的模式，相信已经可以应对实际应用的大多数场景了。
  * 可以看到，Groovy 的语法结合Spock的魔法，确实让单测更加清晰简明。
 */

class HttpClientTest extends Specification {

    //创建一个 HttpClient 实例 httpClient
    HttpClient httpClient = new HttpClient()

    // CloseableHttpClient mock 实例
    CloseableHttpClient syncHttpClient = Mock(CloseableHttpClient)

    def setup() {
        //在 setup 启动方法中，将 syncHttpClient 设置给 httpClient ;
        httpClient.syncHttpClient = syncHttpClient
    }

    def "testHttpClientQuery"() {
        given: "参数"

        //从代码中可以知道，httpClient 依赖 syncHttpClient 的 execute 方法返回的 CloseableHttpResponse 实例，
        // 因此，需要在 given: 块中构造一个 CloseableHttpResponse 实例 resp
        def statusLine = new BasicStatusLine(new ProtocolVersion("Http", 1, 1), 200, "")
        def resp = new HttpResponseProxy(new BasicHttpResponse(statusLine), null)
        resp.statusCode = 200

        def httpEntity = new BasicHttpEntity()
        def respContent = JSON.toJSONString([
                "code": 200, "message": "success", "total": 1200
        ])
        httpEntity.content = new ByteArrayInputStream(respContent.getBytes("utf-8"))
        resp.entity = httpEntity

        when: "when"
        //原来代码这里调用第三方应用并返回结果，此处模拟实现，返回上面given定义的值
        syncHttpClient.execute(_) >> resp
        def callResp = httpClient.query("query", "http://127.0.0.1:80/xxx/yyy/zzz/list")

        then: "结果判断"
        //
        callResp.size() == 3
        callResp[field] == value

        where:
        field     | value
        "code"    | 201
        "message" | "success"
        "total"   | 1200

    }
}