
public class Positions {
    private String name;
    private String counter;
    private int filled;
    private int row;
    private int col;



    //Constructor
    public Positions(String _name, String _counter, int _filled, int _row, int _col) {

    this.name =_name;
    this.counter =_counter;
    this.filled = _filled;
    this.row = _row;
    this.col = _col;

    }
    public int getRow()
    {
        return row;
    }

    public int getCol()
    {
        return col;
    }
    public String getName()
    {
        return name;
    }
    public String getCounter()
    {
        return counter;
    }

    public int getFilled() {
        return filled;
    }

public void setRow(int Row)
{
    this.row = Row;
}
public void setCol(int Col)
{
    this.row = Col;
}
    public void setName(String Name)
    {
        this.name = Name;
    }
    public void setCounter(String Counter)
    {
        this.counter = Counter;
    }

    public void setFilled(int filled)
    {
        this.filled = filled;
    }
}
