package de.kronos197.pathfinding;

import java.util.ArrayList;

/**
 * Created by lenna on 09.02.2017.
 */
public class LadderGame
{
    private final Integer turnCost = 0;
    private Integer countMaxTurns = 7;
    private Integer[] jumps = new Integer[130];
    private Integer score = 0;

    private ArrayList<Integer> closedWays = new ArrayList<>();
    private ArrayList<Integer> closedFileds = new ArrayList<>();

    //private ArrayList<Integer> bannedFields = new ArrayList<>();
   // private ArrayList<Integer> goodFields = new ArrayList<>();

    public static void main(String[] args)
    {
        new LadderGame(args);
    }

    private String[] args;

    public LadderGame(String[] args)
    {
        this.args = args;

        jumps[2] = 27;
        jumps[5] = 16;
        jumps[8] = -2;
        jumps[10] = 3;
        jumps[26] = -25;
        jumps[32] = -1;
        jumps[37] = 3;
        jumps[42] = -26;
        jumps[44] = -1;
        jumps[53] = -4;
        jumps[55] = 26;
        jumps[60] = 35;
        jumps[71] = -24;
        jumps[82] = -10;
        jumps[85] = 25;
        jumps[87] = 28;
        jumps[89] = -25;
        jumps[90] = 27;
        jumps[102] = -25;
        jumps[109] = -10;
        jumps[122] = -9;
        jumps[127] = -20;

        for(int i = 0; i < jumps.length; i++)
        {
            if(jumps[i] == null) jumps[i] = 0;
        }

       // for(int i = 0; i<max; i++){
        //    if(jumps[i] < 0)
        //        bannedFields.add(i);
        //    else if(jumps[i] > 0)
        //        goodFields.add(i);
        //}


        closedFileds.add(1);
        closedWays.add(0);

        while(true)
        {
            Integer filed = closedFileds.get(closedFileds.size()-1);
            Integer[] fields = countFilds(filed);

            Integer step = 0;
            Integer currentMax = 0;

            for(int j = 0; j < fields.length; j++)
            {
                if(fields[j] == null) continue;

                if(currentMax < fields[j])
                {
                    currentMax = fields[j];
                    step = j +1;
                }
            }

            currentMax += filed;

            closedFileds.add(currentMax);
            closedWays.add(step);

            if(currentMax >= jumps.length -1) break;
        }

        for(int i = 0; i < closedFileds.size(); i++)
        {
            System.out.println("Feld: " + closedFileds.get(i) + "  bei einem Würfel von " + closedWays.get(i));
        }
        System.out.println("Züge insgesammt: " + closedFileds.size());
    }

    public Integer[] countFilds(Integer field)
    {
        Integer[] fields = new Integer[6];
        for(Integer i = 0; i < fields.length; i++)
        {
            Integer index = field + (i + 1);


            Integer total = jumps[index] + i + 1;
            fields[i] = total;

            if(index >= jumps.length -1) break;

        }

        return fields;
    }


}
