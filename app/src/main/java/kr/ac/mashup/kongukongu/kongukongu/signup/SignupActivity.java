package kr.ac.mashup.kongukongu.kongukongu.signup;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.kakao.kakaotalk.KakaoTalkService;
import com.kakao.kakaotalk.callback.TalkResponseCallback;
import com.kakao.kakaotalk.response.KakaoTalkProfile;
import com.kakao.network.ErrorResult;

import butterknife.ButterKnife;
import kr.ac.mashup.kongukongu.kongukongu.KakaoProfileInformation;
import kr.ac.mashup.kongukongu.kongukongu.MyAccount;
import kr.ac.mashup.kongukongu.kongukongu.R;
import kr.ac.mashup.kongukongu.kongukongu.SplashActivity;
import kr.ac.mashup.kongukongu.kongukongu.server.RetrofitSingleton;
import kr.ac.mashup.kongukongu.kongukongu.server.ServerBoolResult;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignupActivity extends AppCompatActivity {

    public static final String TAG = SignupActivity.class.getSimpleName();

    private MyAccount myAccount;
    private String profileImageURL;
    private int regionNum = 0;

    KakaoProfileInformation mProfileInformation;
    Spinner spin_signup_region;
    ArrayAdapter<CharSequence> mSpinnerAdapter;
    EditText edit_signup_nickname;
    TextView txt_signup_selectedRegion;
    Button btn_signup_finish;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        ButterKnife.bind(this);

        btn_signup_finish = (Button)findViewById(R.id.btn_signup_finish);
        txt_signup_selectedRegion = (TextView)findViewById(R.id.txt_signup_selectedRegion);
        edit_signup_nickname = (EditText)findViewById(R.id.edit_signup_nickname);
        mProfileInformation = (KakaoProfileInformation) findViewById(R.id.view_signup_profileImage);
        mSpinnerAdapter = ArrayAdapter.createFromResource(this, R.array.region, android.R.layout.simple_spinner_item);
        spin_signup_region = (Spinner) findViewById(R.id.spin_signup_region);

        myAccount = MyAccount.getInstance();
        initializeProfileView();

        btn_signup_finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (regionNum != 0){
                    RetrofitSingleton retrofitSingleton = RetrofitSingleton.getInstance();
                    Call<ServerBoolResult> call = retrofitSingleton.getRegisterUser(
                            myAccount.getKakaoId(), profileImageURL,
                            edit_signup_nickname.getText().toString(), regionNum);

                    call.enqueue(new Callback<ServerBoolResult>() {
                        @Override
                        public void onResponse(Call<ServerBoolResult> call, Response<ServerBoolResult> response) {
                            if (response.body().isbResult()){
                                Toast.makeText(SignupActivity.this, "회원가입 성공" ,Toast.LENGTH_SHORT).show();
                            }else{
                                Toast.makeText(SignupActivity.this, "회원가입 실패" ,Toast.LENGTH_SHORT).show();
                            }
                        }

                        @Override
                        public void onFailure(Call<ServerBoolResult> call, Throwable t) {

                        }
                    });
                }else{
                    Toast.makeText(SignupActivity.this, "지역을 선택해주세요!",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void initializeProfileView() {

        KakaoTalkService.requestProfile(new KakaoTalkResponseCallback<KakaoTalkProfile>() {
            @Override
            public void onSuccess(KakaoTalkProfile result) {
                if (mProfileInformation != null) {
                    profileImageURL = result.getProfileImageUrl();
                    if (profileImageURL != null)
                        mProfileInformation.setProfileURL(profileImageURL);
                }
            }
        });

        mSpinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin_signup_region.setAdapter(mSpinnerAdapter);
        spin_signup_region.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                regionNum = position;
                txt_signup_selectedRegion.setText(String.valueOf(parent.getItemAtPosition(position)));
            }
            public void onNothingSelected(AdapterView<?>  parent) {
            }
        });

    }

    private void redirectMainActivity() {
        startActivity(new Intent(SignupActivity.this, SplashActivity.class));
        finish();
    }

    public abstract class KakaoTalkResponseCallback<T> extends TalkResponseCallback<T> {

        @Override
        public void onNotKakaoTalkUser() {
            Toast.makeText(SignupActivity.this, "not a KakaoTalk user", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onFailure(ErrorResult errorResult) {
            Toast.makeText(SignupActivity.this, "failure : " + errorResult, Toast.LENGTH_LONG).show();
        }

        @Override
        public void onSessionClosed(ErrorResult errorResult) {
            //redirectLoginActivity();
        }

        @Override
        public void onNotSignedUp() {
            //redirectSignupActivity();
        }

        @Override
        public void onDidStart() {
            //showWaitingDialog();
        }

        @Override
        public void onDidEnd() {
            // cancelWaitingDialog();
        }
    }
}
