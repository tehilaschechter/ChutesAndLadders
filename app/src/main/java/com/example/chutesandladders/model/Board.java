package com.example.chutesandladders.model;

import java.util.ArrayList;

public class Board {

    public static ArrayList<Box> getBoxes(){
        return boardBoxList;
    }

    private static final ArrayList<Box> boardBoxList = new ArrayList<Box>() {{
        add(new Box(100, 0, 0, true, false));
        add(new Box(99, 0, 0, false, false));
        add(new Box(98, 0, 0, false, false));
        add(new Box(97, 78, 0, false, false));
        add(new Box(96, 0, 0, false, false));
        add(new Box(95, 0, 0, false, false));
        add(new Box(94, 0, 0, false, false));
        add(new Box(93, 52, 0, false, false));
        add(new Box(92, 0, 0, false, false));
        add(new Box(91, 0, 0, false, false));
        add(new Box(81, 0, 0, false, false));
        add(new Box(82, 0, 99, false, false));
        add(new Box(83, 0, 0, false, false));
        add(new Box(84, 0, 0, false, false));
        add(new Box(85, 0, 0, false, false));
        add(new Box(86, 0, 0, false, false));
        add(new Box(87, 0, 0, false, false));
        add(new Box(88, 0, 0, false, false));
        add(new Box(89, 0, 0, false, false));
        add(new Box(90, 0, 0, false, false));
        add(new Box(80, 0, 0, false, false));
        add(new Box(79, 0, 0, false, false));
        add(new Box(78, 0, 0, false, false));
        add(new Box(77, 0, 0, false, false));
        add(new Box(76, 0, 0, false, false));
        add(new Box(75, 0, 0, false, false));
        add(new Box(74, 37, 0, false, false));
        add(new Box(73, 0, 0, false, false));
        add(new Box(72, 0, 0, false, false));
        add(new Box(71, 0, 0, false, false));
        add(new Box(61, 0, 0, false, false));
        add(new Box(62, 0, 0, false, false));
        add(new Box(63, 0, 0, false, false));
        add(new Box(64, 0, 0, false, false));
        add(new Box(65, 0, 0, false, false));
        add(new Box(66, 0, 0, false, false));
        add(new Box(67, 0, 0, false, false));
        add(new Box(68, 0, 0, false, false));
        add(new Box(69, 0, 0, false, false));
        add(new Box(70, 0, 0, false, false));
        add(new Box(60, 0, 0, false, false));
        add(new Box(59, 0, 0, false, false));
        add(new Box(58, 0, 0, false, false));
        add(new Box(57, 0, 0, false, false));
        add(new Box(56, 0, 0, false, false));
        add(new Box(55, 0, 0, false, false));
        add(new Box(54, 0, 0, false, false));
        add(new Box(53, 0, 0, false, false));
        add(new Box(52, 0, 0, false, false));
        add(new Box(51, 0, 0, false, false));
        add(new Box(41, 0, 0, false, false));
        add(new Box(42, 0, 0, false, false));
        add(new Box(43, 0, 0, false, false));
        add(new Box(44, 0, 0, false, false));
        add(new Box(45, 0, 0, false, false));
        add(new Box(46, 0, 0, false, false));
        add(new Box(47, 0, 0, false, false));
        add(new Box(48, 0, 0, false, false));
        add(new Box(49, 0, 0, false, false));
        add(new Box(50, 12, 0, false, false));
        add(new Box(40, 0, 0, false, false));
        add(new Box(39, 0, 0, false, false));
        add(new Box(38, 0, 0, false, false));
        add(new Box(37, 0, 0, false, false));
        add(new Box(36, 0, 64, false, false));
        add(new Box(35, 0, 0, false, false));
        add(new Box(34, 0, 73, false, false));
        add(new Box(33, 0, 0, false, false));
        add(new Box(32, 0, 0, false, false));
        add(new Box(31, 0, 0, false, false));
        add(new Box(21, 0, 0, false, false));
        add(new Box(22, 0, 0, false, false));
        add(new Box(23, 14, 0, false, false));
        add(new Box(24, 0, 0, false, false));
        add(new Box(25, 0, 0, false, false));
        add(new Box(26, 0, 0, false, false));
        add(new Box(27, 0, 0, false, false));
        add(new Box(28, 0, 0, false, false));
        add(new Box(29, 0, 0, false, false));
        add(new Box(30, 0, 0, false, false));
        add(new Box(20, 0, 0, false, false));
        add(new Box(19, 0, 0, false, false));
        add(new Box(18, 0, 0, false, false));
        add(new Box(17, 0, 0, false, false));
        add(new Box(16, 0, 0, false, false));
        add(new Box(15, 0, 0, false, false));
        add(new Box(14, 0, 0, false, false));
        add(new Box(13, 0, 48, false, false));
        add(new Box(12, 0, 0, false, false));
        add(new Box(11, 0, 0, false, false));
        add(new Box(1, 0, 0, false, false));
        add(new Box(2, 0, 38, false, false));
        add(new Box(3, 0, 0, false, false));
        add(new Box(4, 0, 0, false, false));
        add(new Box(5, 0, 0, false, false));
        add(new Box(6, 0, 0, false, false));
        add(new Box(7, 0, 0, false, false));
        add(new Box(8, 0, 0, false, false));
        add(new Box(9, 0, 0, false, false));
        add(new Box(10, 0, 0, false, false));
    }};

    public static Box getBoxOfSpecificNumber(int boxNumber){

        if(boxNumber > 10 && boxNumber <= 20
                    || boxNumber > 30 && boxNumber <= 40
                    || boxNumber > 50 && boxNumber <= 60
                    || boxNumber > 70 && boxNumber <= 80
                    || boxNumber > 90 && boxNumber <= 100){
            return  boardBoxList.get(boardBoxList.size() - boxNumber);
        }
        else if(boxNumber > 0 && boxNumber <= 10){
            return boardBoxList.get(boxNumber + 89);
        }
        else if(boxNumber > 20 && boxNumber <= 30){
            return boardBoxList.get(boxNumber + 49);
        }
        else if(boxNumber > 40 && boxNumber <= 50){
            return boardBoxList.get(boxNumber + 9);
        }
        else if(boxNumber > 60 && boxNumber <= 70){
            return boardBoxList.get(boxNumber - 31);
        }
        else if(boxNumber > 80 && boxNumber <= 90){
            return boardBoxList.get(boxNumber - 71);
        }
        else if(boxNumber == 0){
            return new Box(0, 0, 0, false, false);
        }

        return null;
    }

}
