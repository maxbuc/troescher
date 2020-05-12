package spe.mch;

public class UserChecker {
      
    public boolean isKunde(Kunde user, String sessionId){
        if(!user.getSessionid().equals(sessionId)){
            return false;
        }
        return true;
    }
    public boolean isAdmin(Kunde user, String sessionId){
        if(isKunde(user, sessionId)){
            
                return true;
           
            
        }
        return true;
    }
}
