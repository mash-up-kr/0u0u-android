package kr.ac.mashup.kongukongu.kongukongu;


import android.app.Application;
import android.content.Context;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;

import com.facebook.drawee.view.SimpleDraweeView;

public class KakaoProfileInformation extends FrameLayout {

    private SimpleDraweeView fresco_profileImage;

    public KakaoProfileInformation(Context context) {
        super(context);
        initView();
    }

    public KakaoProfileInformation(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView();
    }

    public KakaoProfileInformation(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }

    private void initView() {
        View view = inflate(getContext(), R.layout.view_kakao_profile_image, this);
        fresco_profileImage = (SimpleDraweeView) view.findViewById(R.id.user_profile_image);
    }



    /**
     * 프로필 이미지에 대해 view를 update한다.
     * @param profileImageURL 화면에 반영할 프로필 이미지
     */
    public void setProfileURL(final String profileImageURL) {
        if (fresco_profileImage != null && profileImageURL != null) {
            Application app = GlobalApplication.getInstance();
            if (app == null)
                throw new UnsupportedOperationException("needs com.kakao.GlobalApplication in order to use ImageLoader");

            Uri uri = Uri.parse(profileImageURL);
            fresco_profileImage.setImageURI(uri);
        }
    }


}
