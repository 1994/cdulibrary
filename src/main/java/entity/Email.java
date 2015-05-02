package entity;

import java.io.Serializable;

/**
 * Created by reeco_000 on 2015/4/19.
 */
public class Email implements Serializable{

    private static final long serialVersionUID = 1L;

    //发送地址
    private String sendAddress;

    //收信地址
    private String directionAddress;

    //邮件标题
    private String title;

    //邮件内容
    private String content;


    @Override
    public String toString() {
        return "Email{" +
                "sendAddress='" + sendAddress + '\'' +
                ", directionAddress='" + directionAddress + '\'' +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                '}';
    }

    public Email(String sendAddress, String directionAddress, String title, String content) {
        this.sendAddress = sendAddress;
        this.directionAddress = directionAddress;
        this.title = title;
        this.content = content;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Email email = (Email) o;

        if (content != null ? !content.equals(email.content) : email.content != null) return false;
        if (directionAddress != null ? !directionAddress.equals(email.directionAddress) : email.directionAddress != null)
            return false;
        if (sendAddress != null ? !sendAddress.equals(email.sendAddress) : email.sendAddress != null) return false;
        if (title != null ? !title.equals(email.title) : email.title != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = sendAddress != null ? sendAddress.hashCode() : 0;
        result = 31 * result + (directionAddress != null ? directionAddress.hashCode() : 0);
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (content != null ? content.hashCode() : 0);
        return result;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getSendAddress() {
        return sendAddress;
    }

    public void setSendAddress(String sendAddress) {
        this.sendAddress = sendAddress;
    }

    public String getDirectionAddress() {
        return directionAddress;
    }

    public void setDirectionAddress(String directionAddress) {
        this.directionAddress = directionAddress;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
