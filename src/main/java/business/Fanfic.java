package business;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "fanfics")
public class Fanfic implements Serializable {
    private static final long serialVersionUID = 2L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "fanfic_id")
    private Long fanficId;

    @Column(name = "title", nullable = false, unique = true)
    private String title;

    @Column(name = "content", nullable = false, unique = true, length = 65535)
    private String content;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User author;


    public Fanfic(){

    }

    public Long getFanficId() {
        return fanficId;
    }

    public void setFanficId(Long fanficId) {
        this.fanficId = fanficId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Fanfic fanfic = (Fanfic) o;
        return Objects.equals(fanficId, fanfic.fanficId) &&
                Objects.equals(title, fanfic.title) &&
                Objects.equals(content, fanfic.content);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fanficId, title, content);
    }

    @Override
    public String toString() {
        return "Fanfic{" +
                "fanficId=" + fanficId +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
