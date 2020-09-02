package com.stark.geekbrains_edu.presentation.StartScreen;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.Task;
import com.google.android.material.button.MaterialButton;
import com.stark.geekbrains_edu.R;
import com.stark.geekbrains_edu.presentation.weather.WeatherFragment;

import java.util.concurrent.Executor;

public class StartScreenFragment extends Fragment {

    StartPresenter startPresenter = new StartPresenter();
    private static final int RC_SIGN_IN = 40404;
    private static final String TAG = "GoogleAuth";

    private GoogleSignInClient googleSignInClient;

    private com.google.android.gms.common.SignInButton buttonSignIn;
    private MaterialButton buttonSingOut;

    public StartScreenFragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_startscreen, container, false);
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();
        googleSignInClient = GoogleSignIn.getClient(getContext(), gso);
        buttonSignIn = rootView.findViewById(R.id.sign_in_button);
        buttonSignIn.setOnClickListener(v -> signIn());
        buttonSingOut = rootView.findViewById(R.id.sign_out_button);
        buttonSingOut.setOnClickListener(v -> signOut());

        return rootView;
    }

    @Override
    public void onStart() {
        super.onStart();
        enableSign();
        GoogleSignInAccount account = GoogleSignIn.getLastSignedInAccount(getContext());
        if (account != null) {
            disableSign();
            buttonSignIn.setEnabled(false);
            updateUI(account.getEmail());
        }
    }

    private void handleSignInResult(Task<GoogleSignInAccount> completedTask) {
        try {
            GoogleSignInAccount account = completedTask.getResult(ApiException.class);
            buttonSignIn.setEnabled(false);
            updateUI(account.getEmail());
            disableSign();
        } catch (ApiException e) {
            Log.w(TAG, "signInResult:failed code= " + e.getStatusCode());
        }
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == RC_SIGN_IN) {
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            handleSignInResult(task);
            startPresenter.navigate(getFragmentManager(), R.id.frgmCont, new WeatherFragment());
        }

    }

    private void signIn() {
        Intent signInIntent = googleSignInClient.getSignInIntent();
        startActivityForResult(signInIntent, RC_SIGN_IN);
    }

    private void signOut() {
        googleSignInClient.signOut()
                .addOnCompleteListener((Executor) this, task -> {
                    updateUI("email");
                    enableSign();
                });
    }


    private void updateUI(String idToken) {
        TextView token = requireActivity().findViewById(R.id.token);
        token.setText(idToken);
    }



    private void enableSign(){
        buttonSignIn.setEnabled(true);
        buttonSingOut.setEnabled(false);
    }

    private void disableSign(){
        buttonSignIn.setEnabled(false);
        buttonSingOut.setEnabled(true);
    }


}
