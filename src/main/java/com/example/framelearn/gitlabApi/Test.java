package com.example.framelearn.gitlabApi;

import cn.hutool.http.HttpResponse;
import cn.hutool.http.HttpUtil;
import org.gitlab4j.api.GitLabApi;
import org.gitlab4j.api.GitLabApiException;
import org.gitlab4j.api.models.Project;

import java.util.List;

/**
 * @author jt
 * @date 2020-8-25
 */
public class Test {

    public static void main(String[] args) throws GitLabApiException {

     //   Create a GitLabApi instance to communicate with your GitLab server
//        GitLabApi gitLabApi = new GitLabApi("http://your.gitlab.server.com", "YOUR_PERSONAL_ACCESS_TOKEN");

        GitLabApi gitLabApi = GitLabApi.oauth2Login("http://192.168.145.203:8081", "root", "password");

// Get the list of projects your account has access to
        List<Project> projects = gitLabApi.getProjectApi().getProjects();
        for (Project project : projects) {

            System.out.println(project.getName());
        }

//        gitLabApi.getMergeRequestApi().createMergeRequest()

    }
}
