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

public class FirebaseRegisterUser
{
    private FirebaseAuth mAuth;
    private Context context;

    public FirebaseRegisterUser(Context context)
    {
        this.context = context;
        mAuth = FirebaseAuth.getInstance();
    }

    // Método para registrar o usuário com email e senha
    public void registerUser(String sEmail, String sPassword)
    {
        mAuth.createUserWithEmailAndPassword(sEmail, sPassword)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>()
                {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task)
                    {
                        if (task.isSuccessful())
                        {
                            // Registro realizado com sucesso
                            FirebaseUser user = mAuth.getCurrentUser();
                            Toast.makeText(context, "Registro realizado com sucesso!", Toast.LENGTH_SHORT).show();

                            // Obter o token do Firebase após o registro
                            obtemAtualizacaoToken();
                        }
                        else
                        {
                            // Falha no registro
                            Toast.makeText(context, "Falha no registro: " + task.getException().getMessage(), Toast.LENGTH_LONG).show();
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
                        if (task.isSuccessful())
                        {
                            String token = task.getResult();
                            Toast.makeText(context, "Token obtido: " + token, Toast.LENGTH_SHORT).show();
                            // Aqui, você pode salvar o token em SharedPreferences, se necessário
                        }
                        else
                        {
                            Toast.makeText(context, "Falha ao obter o token", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
}
