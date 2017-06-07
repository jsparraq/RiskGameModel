
package dsd.model.game;


public class Players {
   
   private String color ;
   private Account account;
   private boolean host;
   private boolean online;
  

    public Players(Account account,String color,boolean  host,boolean online){
        this.account=account;
        this.color=color;
        this.host=host;
        this.online=online;
       
    }
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public boolean isHost() {
        return host;
    }

    public void setHost(boolean host) {
        this.host = host;
    }

    public boolean isOnline() {
        return online;
    }

    public void setOnline(boolean online) {
        this.online = online;
    }

    
    
}
