package pojo;

import java.time.LocalDateTime;

public class Comment {
    private Integer id;
    private String userName;
    private String bookName;
    private LocalDateTime commentTime;
    private String content;

    public Comment() {
    }

    public Comment(Integer id, String userName, String bookName, LocalDateTime commentTime, String content) {
        this.id = id;
        this.userName = userName;
        this.bookName = bookName;
        this.commentTime = commentTime;
        this.content = content;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public LocalDateTime getCommentTime() {
        return commentTime;
    }

    public void setCommentTime(LocalDateTime commentTime) {
        this.commentTime = commentTime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", bookName='" + bookName + '\'' +
                ", commentTime=" + commentTime +
                ", content='" + content + '\'' +
                '}';
    }
}
