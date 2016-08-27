package kr.ac.mashup.kongukongu.kongukongu.profile;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.TextView;

import com.kakao.kakaotalk.KakaoTalkService;
import com.kakao.kakaotalk.response.KakaoTalkProfile;

import kr.ac.mashup.kongukongu.kongukongu.MyAccount;
import kr.ac.mashup.kongukongu.kongukongu.R;
import kr.ac.mashup.kongukongu.kongukongu.RegionConverter;
import kr.ac.mashup.kongukongu.kongukongu.server.RetrofitSingleton;
import kr.ac.mashup.kongukongu.kongukongu.server.ServerBoolResult;
import kr.ac.mashup.kongukongu.kongukongu.server.ServerUserResult;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProfileActivity extends AppCompatActivity {

    public static final String TAG = ProfileActivity.class.getSimpleName();

    private MyAccount myAccount;
    private RegionConverter regionConverter;

    Toolbar toolbar;
    TextView txt_profile_nickname;
    TextView txt_profile_region;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("프로필");
        toolbar.setTitleTextColor(Color.parseColor("#ffffff"));
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        txt_profile_nickname = (TextView)findViewById(R.id.txt_profile_nickname);
        txt_profile_region = (TextView)findViewById(R.id.txt_profile_region);

        myAccount = MyAccount.getInstance();
        regionConverter = RegionConverter.getInstance();
        initializeProfileView();
    }

    private void initializeProfileView() {
        RetrofitSingleton retrofitSingleton = RetrofitSingleton.getInstance();
        Call<ServerUserResult> call = retrofitSingleton.getUserInfo(myAccount.getKakaoId());
        call.enqueue(new Callback<ServerUserResult>() {
            @Override
            public void onResponse(Call<ServerUserResult> call, Response<ServerUserResult> response) {
                txt_profile_nickname.setText(response.body().getNickname());

                regionConverter.RegionNumToString(response.body().getRegionNum());
                txt_profile_region.setText(regionConverter.getRegionString());
            }

            @Override
            public void onFailure(Call<ServerUserResult> call, Throwable t) {
                Log.v(TAG ," " + t.getMessage());
            }
        });

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) ;
        finish();
        return super.onOptionsItemSelected(item); //Todo 리턴으로 이렇게 super 가는건 뭔가?
    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.in_from_right, R.anim.out_to_right);
    }
}
