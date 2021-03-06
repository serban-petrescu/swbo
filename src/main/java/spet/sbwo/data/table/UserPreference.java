package spet.sbwo.data.table;

import spet.sbwo.data.base.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "T_USER_PREFERENCE")
public class UserPreference extends BaseEntity {
    @Column(name = "C_LANGUAGE")
    private String language;

    @Column(name = "C_THEME")
    private String theme;

    @Column(name = "C_DRAFT_RESUME_DELAY")
    private int draftResumeDelay;

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public int getDraftResumeDelay() {
        return draftResumeDelay;
    }

    public void setDraftResumeDelay(int draftResumeDelay) {
        this.draftResumeDelay = draftResumeDelay;
    }

    @Override
    public String toString() {
        return "UserPreference [id=" + id + ", language=" + language + ", theme=" + theme
            + ", draftResumeDelay=" + draftResumeDelay + "]";
    }

}
