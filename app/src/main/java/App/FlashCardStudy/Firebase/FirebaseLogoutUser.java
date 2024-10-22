package App.FlashCardStudy.Firebase;

import com.google.firebase.auth.FirebaseAuth;

public class FirebaseLogoutUser
{
    //Variaveis da classe
    private FirebaseAuth auth = null;

    public void logoutUser()
    {
        //Pega a instancia do firebase
        auth = FirebaseAuth.getInstance();
        //Faz o logout
        auth.signOut();
    }
}
