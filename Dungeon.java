/*
 * Author:Esvarabala Kannan
 * Project:Dungeon.java
 * Purpose:To create a dungeon and interact with it
 * Notes:The shift program has quite a few glitches but everything else runs fine.Have Fun!
 * */
package Dungeon;//package name is Dungeon
import java.util.Random;
public class Dungeon {
private Monster[][] monsters;
public static int gridWidth;
public static int gridHeight;
public Dungeon(int width, int height){
	Dungeon.gridWidth=width;
	Dungeon.gridHeight=height;
	monsters=new Monster[gridHeight][gridWidth];
	for(int a=0;a<gridHeight;a++){
	     for(int b=0;b<gridWidth;b++){
	    	 monsters[a][b]=new Monster();}}
	}
public void updateMonster(int x, int y, Monster m){
	if(monsters[y][x].getLevel()!=-1){}
	else if(x>gridWidth || y>gridHeight){}
	else{monsters[y][x]=m;}
}
 private void swap(int x1, int y1, int x2, int y2){
	 Monster temp=monsters[y1][x1];
	 monsters[y1][x1]=monsters[y2][x2];
	 monsters[y2][x2]=temp;
 }
 public void shuffle(){
	 Random rand=new Random();
	for(int a=0;a<gridHeight;a++){
	     for(int b=0;b<gridWidth;b++){
	    	int c=rand.nextInt(gridWidth);
	    	int d=rand.nextInt(gridHeight);
	    	 swap(a,b,c,d);}}
 }
 public void shift(char command){
	 String move=Character.toString(command);
	 if(move.equals("w")){
		 for(int a=0;a<gridHeight;a++){
	     for(int b=0;b<gridWidth;b++){
	      if(a-1<0){monsters[gridHeight-1][b]=monsters[a][b];}
	      else{monsters[a-1][b]=monsters[a][b];}}}}
	 else if(move.equals("a")){
		 for(int a=0;a<gridHeight;a++){
		     for(int b=0;b<gridWidth;b++){
		      if(b-1<0){monsters[a][gridWidth-1]=monsters[a][b];}
		      else{monsters[a][b-1]=monsters[a][b];}}}}
	 else if(move.equals("s")){
		 for(int a=0;a<gridHeight;a++){
		     for(int b=0;b<gridWidth;b++){
		      if(a+1>=gridHeight){monsters[0][b]=monsters[a][b];}	 
		      else{monsters[a+1][b]=monsters[a][b];}}}}
	 else if(move.equals("d")){
		 for(int a=0;a<gridHeight;a++){
		     for(int b=0;b<gridWidth;b++){
		      if(b+1>=gridWidth){monsters[a][0]=monsters[a][b];}
		      else{monsters[a][b+1]=monsters[a][b];}}}}
	 else{System.out.println("Invalid input");}
 }
 public String printInfo(){
	 System.out.println(monsters[0][0]);
	 String maze="";
	 for(int row=0;row<gridHeight;row++){
	maze+="\n";
     for(int col=0;col<gridWidth;col++){
    	 maze+="\t"+ monsters[row][col].getInfo();
	 }
    }
	 return maze;
 } 
}
