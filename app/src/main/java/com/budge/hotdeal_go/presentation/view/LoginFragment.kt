package com.budge.hotdeal_go.presentation.view

import android.app.Activity.RESULT_CANCELED
import android.app.Activity.RESULT_OK
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.viewModels
import com.budge.hotdeal_go.BuildConfig
import com.budge.hotdeal_go.R
import com.budge.hotdeal_go.databinding.FragmentLoginBinding
import com.budge.hotdeal_go.presentation.base.BaseFragment
import com.budge.hotdeal_go.presentation.viewmodel.LoginViewModel
import com.kakao.sdk.auth.model.OAuthToken
import com.kakao.sdk.common.model.ClientError
import com.kakao.sdk.common.model.ClientErrorCause
import com.kakao.sdk.user.UserApiClient
import com.navercorp.nid.NaverIdLoginSDK
import dagger.hilt.android.AndroidEntryPoint

private const val TAG = "LoginFragment_트라"

@AndroidEntryPoint
class LoginFragment : BaseFragment<FragmentLoginBinding>(
    FragmentLoginBinding::inflate,
    R.layout.fragment_login
) {

    private val viewModel: LoginViewModel by viewModels()

    private val callback: (OAuthToken?, Throwable?) -> Unit = { token, error ->
        if (error != null) {
            Log.e(TAG, "카카오계정으로 로그인 실패", error)
        } else if (token != null) {
            Log.i(TAG, "카카오계정으로 로그인 성공 ${token.accessToken}")
            viewModel.loginWithKakao(token.accessToken)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setNaverLogin()
        setEvent()
        setObserve()
    }

    private fun setObserve() {
        viewModel.logInState.observe(viewLifecycleOwner) { isLoggedIn ->
            if(isLoggedIn){
                val intent = Intent().apply {
                    putExtra("LogInResult", isLoggedIn)
                }
                requireActivity().setResult(RESULT_OK, intent)
                requireActivity().finish()
            }
        }


    }

    private fun setNaverLogin() {
        NaverIdLoginSDK.initialize(
            requireContext(),
            BuildConfig.NAVER_CLIENT_ID,
            BuildConfig.NAVER_CLIENT_SECRET,
            getString(R.string.app_name)
        )
        val launcher =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
                when (result.resultCode) {
                    RESULT_OK -> {
                        // 네이버 로그인 인증이 성공했을 때 수행할 코드 추가
                        Log.d(TAG, "네이버 로그인 성공 : ${NaverIdLoginSDK.getAccessToken()}")
                    }

                    RESULT_CANCELED -> {
                        // 실패 or 에러
                        val errorCode = NaverIdLoginSDK.getLastErrorCode().code
                        val errorDescription = NaverIdLoginSDK.getLastErrorDescription()
                        Log.d(TAG, "네이버 로그인 실패 : errorCode:$errorCode, errorDesc:$errorDescription")
                    }
                }
            }

        binding.ibNaverLogin.setOAuthLogin(launcher)
    }

    private fun setEvent() {
        binding.ibKakaoLogin.setOnClickListener {
            startKakaoLogin()
        }
    }

    private fun startKakaoLogin() {
        if (UserApiClient.instance.isKakaoTalkLoginAvailable(requireContext())) {
            UserApiClient.instance.loginWithKakaoTalk(requireContext()) { token, error ->
                if (error != null) {
                    Log.e(TAG, "카카오톡으로 로그인 실패", error)

                    // 사용자가 카카오톡 설치 후 디바이스 권한 요청 화면에서 로그인을 취소한 경우,
                    // 의도적인 로그인 취소로 보고 카카오계정으로 로그인 시도 없이 로그인 취소로 처리 (예: 뒤로 가기)
                    if (error is ClientError && error.reason == ClientErrorCause.Cancelled) {
                        return@loginWithKakaoTalk
                    }

                    // 카카오톡에 연결된 카카오계정이 없는 경우, 카카오계정으로 로그인 시도
                    UserApiClient.instance.loginWithKakaoAccount(
                        requireContext(),
                        callback = callback
                    )
                } else if (token != null) {
                    Log.i(TAG, "카카오톡으로 로그인 성공 ${token.accessToken}")
                    viewModel.loginWithKakao(token.accessToken)
                }
            }
        } else {
            UserApiClient.instance.loginWithKakaoAccount(requireContext(), callback = callback)
        }
    }


}