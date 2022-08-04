package EEfirstChapter3;

import java.util.ArrayList;

public class FManager {
    private static Long id =4l;
    private static ArrayList<Player> allPlayers = new ArrayList<>();


    static {
        allPlayers.add((new Player(1L,"Vinicius","Junior",6000000,"Real Madrid",70000000)));
        allPlayers.add((new Player(2L,"Ruslan","Malinovslyi",400000,"Atlanta",15000000)));
        allPlayers.add((new Player(3L,"Vinicius","Junior",3000000,"Real Sociedad",11000000)));
    }
    public static void addPlayer(Player player){
        player.setId(id);
        allPlayers.add(player);
        id++;
    }
    public static ArrayList<Player> getAllPlayers(){
        return allPlayers;
    }
}

