package entity;

import java.util.Map;

/**
 * Created by reeco_000 on 2015/4/26.
 */
public class BatchEmail {

    private Boolean use_same_subject;

    private Map<String,String> emails;

    public Boolean getUse_same_subject() {
        return use_same_subject;
    }

    public void setUse_same_subject(Boolean use_same_subject) {
        this.use_same_subject = use_same_subject;
    }

    public Map<String, String> getEmails() {
        return emails;
    }

    public void setEmails(Map<String, String> emails) {
        this.emails = emails;
    }

    @Override
    public String toString() {
        return "BatchEmail{" +
                "use_same_subject=" + use_same_subject +
                ", emails=" + emails +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BatchEmail that = (BatchEmail) o;

        if (!emails.equals(that.emails)) return false;
        if (!use_same_subject.equals(that.use_same_subject)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = use_same_subject.hashCode();
        result = 31 * result + emails.hashCode();
        return result;
    }
}
