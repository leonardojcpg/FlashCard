package App.FlashCardStudy.Firebase;

import android.content.Context;
import android.widget.Toast;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import androidx.annotation.NonNull;

public class FirebaseLoginUser
{
    //Variaveis da classe
    private final FirebaseAuth mAuth;
    private final Context context;

    public FirebaseLoginUser(Context context)
    {
        this.context = context;
        mAuth = FirebaseAuth.getInstance();
    }

    // Método para login do usuário com email e senha
    public void loginUser(String sEmail, String sPassword)
    {
        mAuth.signInWithEmailAndPassword(sEmail, sPassword)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>()
                {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task)
                    {
                        if (task.isSuccessful()) {
                            // Login realizado com sucesso
                            FirebaseUser user = mAuth.getCurrentUser();
                            Toast.makeText(context, "Login realizado com sucesso!", Toast.LENGTH_SHORT).show();
                            // Obter o token do Firebase após o login
                            obtemAtualizacaoToken();
                        } else {
                            // Falha no login
                            Toast.makeText(context, "Falha no login: " + task.getException().getMessage(), Toast.LENGTH_LONG).show();
                        }
                    }
                });
    }

    // Método para obter o token do Firebase
    private void obtemAtualizacaoToken()
    {

        FirebaseMessaging.getInstance().getToken().addOnCompleteListener(new OnCompleteListener<String>()
                {
                    @Override
                    public void onComplete(@NonNull Task<String> task)
                    {
                        String sToken = "";

                        if (task.isSuccessful())
                        {
                            sToken = task.getResult();
                            Toast.makeText(context, "Token obtido: " + sToken, Toast.LENGTH_SHORT).show();
                            // Aqui, você pode salvar o token em SharedPreferences, se necessário
                        } else {
                            Toast.makeText(context, "Falha ao obter o token", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
}
