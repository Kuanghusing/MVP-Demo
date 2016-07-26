package com.kuahusg.v2exwithmvp.Model;

/**
 * Created by kuahusg on 16-7-25.
 */


import java.io.Serializable;

/**
 * model: hot news
 */
public class News implements Serializable {
    Member member;
    Node node;
    String id;
    String title;
    String content;
    String content_rendered;
    String url;

    public News(Member member, Node node, String id, String title, String content, String content_rendered, String url) {
        this.member = member;
        this.node = node;
        this.id = id;
        this.title = title;
        this.content = content;
        this.content_rendered = content_rendered;
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public Member getMember() {
        return member;
    }

    public Node getNode() {
        return node;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public String getContent_rendered() {
        return content_rendered;
    }


    public static class Member implements Serializable {
        String id;
        String username;
        String avatar_normal;

        public Member(String id, String username, String avatar_normal) {
            this.id = id;
            this.username = username;
            this.avatar_normal = avatar_normal;
        }

        public String getId() {
            return id;
        }

        public String getUsername() {
            return username;
        }

        public String getAvatar_normal() {
            return avatar_normal;
        }
    }

    public static class Node implements Serializable {
        String id;
        String name;
        String title;
        String url;
        String avatar_normal;


        public Node(String id, String name, String title, String url, String avatar_normal) {
            this.id = id;
            this.name = name;
            this.title = title;
            this.url = url;
            this.avatar_normal = avatar_normal;
        }

        public String getUrl() {
            return url;
        }

        public String getTitle() {
            return title;
        }

        public String getName() {
            return name;
        }

        public String getId() {
            return id;
        }

        public String getAvatar_normal() {
            return avatar_normal;
        }
    }

}
