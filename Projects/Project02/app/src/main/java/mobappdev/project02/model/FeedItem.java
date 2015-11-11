package mobappdev.project02.model;

import java.util.Date;

/**
 * Created by Bobby on 11/10/2015.
 */
public class FeedItem {
    private String mEmail;
    private Date mPostedDate;
    private String mContent;
    private String mPhotoPath;

    public String getEmail() {
        return mEmail;
    }

    public void setEmail(String email) {
        mEmail = email;
    }

    public Date getPostedDate() {
        return mPostedDate;
    }

    public void setPostedDate(Date postedDate) {
        mPostedDate = postedDate;
    }

    public String getContent() {
        return mContent;
    }

    public void setContent(String content) {
        mContent = content;
    }

    public String getPhotoPath() {
        return mPhotoPath;
    }

    public void setPhotoPath(String photoPath) {
        mPhotoPath = photoPath;
    }
}
