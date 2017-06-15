

//Strut
public class Player {
    private int userID;
    private String counter;
    private int turn;


    //Constructor
    public Player(int _userID, String _counter,int _turn) {

        this.userID = _userID;
        this.counter = _counter;
        this.turn = _turn;
    }



 //getters
    public int getPlayerId()
{
    return userID;
}

public int turn()
{
    return turn;
}

public String counter()
{
    return counter;
}

//Setters
public void setPlayerId(int userID)
{
    this.userID = userID;
}

public void setCounter(String counter)
{
    this.counter = counter;
}

public void setTurn(int turn)
{
    this.turn = turn;
}


}