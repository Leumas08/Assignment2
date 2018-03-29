import javax.swing.JOptionPane;

import java.awt.Font;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.swing.JFrame;
import javax.swing.JLabel;
public class Complete {
	
	public static String[] posts() {
		 String[] post= null;
		try {
			 int i=0;
			 int j=0;
			 
			 String usless;
		FileReader post1=new FileReader("redditPosts.txt");
		FileReader post2=new FileReader("redditPosts.txt");
		BufferedReader readpost1= new BufferedReader(post1);
		BufferedReader readpost2= new BufferedReader(post2);
		 while (readpost1.ready()) {
			 usless=(readpost1.readLine());
			 i= i+1;
		 }
		 String[] posts= new String[i];
		while (readpost2.ready()) {
			posts[j]= (readpost2.readLine()).toLowerCase();
			j=j+1;
		}
		post=posts;
		 }catch (IOException e) {
  			System.out.println("Sorry an error has occured");
  		 }
			return post;
		 }
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	public static String[] names() {
		String author[] = null;
		String filename="";
		String it="";
		 try {
			 int i=1;
			 int j=0;
		FileReader file1=new FileReader("redditAutors.txt");
		FileReader authfile=new FileReader("redditAutors.txt");
        BufferedReader authors = new BufferedReader(authfile);
        BufferedReader file2= new BufferedReader(file1);
		 while ((authors.ready())) {
        	it=(authors.readLine());
        	i= i+1;
		 }
		 String[] authortry= new String[i];
		 while (file2.ready()) {
			 authortry[j]= (file2.readLine());
			 j= j+1;
		 }
		  author=authortry;
		 }catch (IOException e) {
    			System.out.println("Sorry an error has occured");
    		}
		return author;
	} 
	///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public static String[] comment_count() {
		 String[] com_count= null;
		try {
			 int i=0;
			 int j=0;
			 
			 String usless;
		FileReader com1=new FileReader("ReditCommentCount.txt");
		FileReader com2=new FileReader("ReditCommentCount.txt");
		BufferedReader Bcom1= new BufferedReader(com1);
		BufferedReader Bcom2= new BufferedReader(com2);
		while (Bcom1.ready()) {
			 usless=(Bcom1.readLine());
			 i= i+1;
		 }
		 String[] coms= new String[i];
		while (Bcom2.ready()) {
			coms[j]= (Bcom2.readLine()).toLowerCase();
			j=j+1;
		}
		com_count=coms;
		 }catch (IOException e) {
 			System.out.println("Sorry an error has occured");
 		 }
			return com_count;
		 }
	///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public static String[] score() {
		 String[] scores= null;
		 String useless=null;
		try {
			 int i=0;
			 int j=0;
		FileReader score1=new FileReader("Reditscore.txt");
		FileReader score2=new FileReader("Reditscore.txt");
		BufferedReader Bscore1= new BufferedReader(score1);
		BufferedReader Bscore2= new BufferedReader(score2);
		 while (Bscore1.ready()) {
			 useless=(Bscore1.readLine());
			 i= i+1;
		 }
		 String[] coms= new String[i];
		while (Bscore2.ready()) {
			coms[j]= (Bscore2.readLine()).toLowerCase();
			j=j+1;
		}
		scores=coms;

		 }catch (IOException e) {
			System.out.println("Sorry an error has occured");
		 }
			return scores;
		 }
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public static String[] wordcount() {
		String[] author= null;
		String[] post= null;
		int j= 0;
		int q=0;
		author=names();
		post=posts();
		j=author.length-1;
	    
	    StringBuilder wordandcount = new StringBuilder();
	    
		for (int k=0; k<j; k++) {
        	q=0;
        	List<String> list= Arrays.asList(post[k].replace("..", "").split(" "));
        	Set<String> uniqueWords = new HashSet<String>(list);
        		for (String word : uniqueWords) {
        	    wordandcount.append(word + " "+ Collections.frequency(list, word)+"\n");
        	    q=q+1;
        		}
        	wordandcount.append("thisisabreakingpoint");
        }
        String[] word_counts= wordandcount.toString().split("thisisabreakingpoint");
        return word_counts;
	}
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public static String[][] everything(){
		int q=0;
		String[]author;
		String []wordsets=null;
	    String[] word_counts=null;

	    int k=0;
	    int total_authors=0;
	    word_counts=wordcount(); 
	    author=names();
	    total_authors= author.length;
	    int [] parts_per_author= new int[total_authors];
	    for (int i = 0; i<author.length-1; i++) {
	    	wordsets=word_counts[i].split("\n");
	    	parts_per_author[i]= wordsets.length;
	    }
	    int Sum_of_each_line=0;
	    for (int p= 0; p<total_authors; p++) {
	    	Sum_of_each_line=Sum_of_each_line+parts_per_author[p];
	    }
	    String [][] everything= new String[Sum_of_each_line][4];
	    for (int c=0; c<total_authors-1; c++) {
	    	String [] wordandcount=word_counts[c].split("\n");
	    	k= wordandcount.length;
	    	for(int cc=0; cc<k;cc++) {
	    		String[] wordthencount=wordandcount[cc].split(" ");
	    		everything[q][0]=author[c];
	    		everything[q][1]=wordthencount[0];
	    		if(everything[q][1].equals("u.s.")) {
	    		}
	    		else {
	    			everything[q][1]=everything[q][1].replace(".", "");
	    		}
	    		everything[q][2]=wordthencount[1];
	    		everything[q][3]="Post "+c;
	    		q=q+1;
	    	}
	    }
	    return everything;
	}
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public static String[] eachauthor() {
		String[] author= names();
		String[] authors=names();
		int numauthors=author.length-1;
		int counting=0;
		int p=0;
		for (int i=0; i<numauthors-1;i++) {
			for(int j=i+1; j<numauthors-1;j++) {
				if(authors[i].equals(author[j])) {
					author[j]="repeatedauthor!";
					}
				}
			}
		for (int i=0; i<numauthors-1;i++) {
				if(author[i].equals("repeatedauthor!")) {
					authors[i]=null;
			}
		}
		for (int i=0; i<author.length;i++) {
	    	if (authors[i]==null) {
	    		counting=counting+1;
	    	}
	    }
		String[] eachauthor=new String[authors.length-counting];
		for (int i=0; i<author.length;i++) {
	    	if (authors[i] !=null) {
	    		eachauthor[p]=authors[i];
	    		p=p+1;
	    	}
	    }
		String temp0;
		int n=eachauthor.length;
		for (int i = 0; i < n; i++) 
	    {
	        for (int j = i + 1; j < n; j++) 
	        {
            if (eachauthor[i].compareTo(eachauthor[j])>0) 
            {			
        				temp0 = eachauthor[i];
                        eachauthor[i]= eachauthor[j];
                        eachauthor[j]= temp0;
          }
         }
	    }
		return eachauthor;
	}
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public static String[][] sorter() {
		String [][] everything=everything();
		String temp0;
		String temp1;
		String temp2;
		String temp3;
		int n=everything.length;
		for (int i = 0; i < n; i++) 
	    {
	        for (int j = i + 1; j < n; j++) 
	        {
	            if (everything[i][0].compareTo(everything[j][0])>0) 
	            {
	                temp0 = everything[i][0];
	                temp1 = everything[i][1];
	                temp2 = everything[i][2];
	                temp3=everything[i][3];
	                everything[i][0] = everything[j][0];
	                everything[i][1] = everything[j][1];
	                everything[i][2] = everything[j][2];
	                everything[i][3]=everything[j][3];
	                everything[j][0] = temp0;
	                everything[j][1] = temp1;
	                everything[j][2] = temp2;
	                everything[j][3]=temp3;
	                
	            }
	        }
	    }
		return everything;
	}
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public static String[][] basic (){

		String [] scores=score();
		String [] com_count=comment_count();
		String [] authors=names();
		String[][] generic= new String[authors.length][5];
		String []wordsets=null;
	    String[] word_counts=null;
	    
	    int total_authors=0;
	    word_counts=wordcount(); 
	    total_authors= authors.length;
	    int [] parts_per_author= new int[total_authors];
	    for (int i = 0; i<authors.length-1; i++) {
	    	wordsets=word_counts[i].split("\n");
	    	parts_per_author[i]= wordsets.length;
	    }
	    int Sum_of_each_line=0;
	    for (int p= 0; p<total_authors; p++) {
	    	Sum_of_each_line=Sum_of_each_line+parts_per_author[p];
	    }
		
		generic[0][0]= "Post #";
		generic[0][1]= "   Author";
		generic[0][2]="Number of Comments";
		generic[0][3]="   Score";
		generic[0][4]="Total Words";
		for (int i=0; i<scores.length; i++) {
			generic[i+1][0]="Post "+(i+1)+":";
			generic[i+1][1]=authors[i];
			generic[i+1][2]="   "+com_count[i];
			generic[i+1][3]="  "+scores[i];
			generic[i+1][4]="  "+parts_per_author[i]+"";
			}
		return generic;
	}
	public static String[][] Asearcher(String input){
		String [][] everything=everything();
		int num_posts=1;
		int num_words=0;
		for (int i=0; i<everything.length; i++) {
			if(everything[i][0].equals(input)) {
				num_words++;
			}
		}
		if(num_words==0) {
			
		}
		String[][] Output=new String[num_words+2][4];
		int k=2;
		Output[0][0]="Results for the user: "+input;
		Output[0][1]="";
		Output[0][2]="";
		Output[0][3]="";
		Output[1][0]="Post Number";
		Output[1][1]="Words Used";
		Output[1][2]="Times Used per Post";
		Output[1][3]="Total Posts";
		
		for (int j=0; j<everything.length; j++) {
			if(everything[j][0].equals(input)) {
				Output[k][0]=everything[j][3];
				Output[k][1]=everything[j][1];
				Output[k][2]=everything[j][2];
				Output[k][3]="";
				k++;
			}}
		String[][] temp=new String[Output.length][7];
		int repeats=0;
		
		for (int j=2; j<Output.length-1; j++) {
			/*Post Total*/
			if(Output[j][0].equals(Output[j+1][0])) {
			}else {
				num_posts++;
			}}
		Output[2][3]=Integer.toString(num_posts);
		return Output;
		}
	///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public static String[][] searcher(String input){
		String [][] everything=everything();
		int word_count=0;
		int num_posts=0;
		for (int i=0; i<everything.length; i++) {
			if(everything[i][1].equals(input)) {
				word_count+=Integer.parseInt(everything[i][2]);
				num_posts++;
			}
		}
		String[][] Output=new String[num_posts+2][4];
		int k=2;
		Output[0][0]="Results for the word: "+input;
		Output[0][1]="";
		Output[0][2]="";
		Output[0][3]="";
		Output[1][0]="Post Number";
		Output[1][1]="Author";
		Output[1][2]="Times Used";
		Output[1][3]="Total Usage";
		
		for (int j=0; j<everything.length; j++) {
			if(everything[j][1].equals(input)) {
				Output[k][0]=everything[j][3];
				Output[k][1]=everything[j][0];
				Output[k][2]=everything[j][2];
				Output[k][3]="";
				k++;
			}
		}
		Output[2][3]=Integer.toString(word_count);
		return Output;
	}
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public static void main(String[] args) {
		  JFrame errorJ= new JFrame();
		  JLabel errorL= new JLabel();
		  JFrame closeJ= new JFrame();
		  JLabel closeL= new JLabel();
		  JFrame blankJ= new JFrame();
		  JLabel blankL= new JLabel();
		char [] illegalchar={'#', '%', '&', '{', '}','<', '>','*',  '?', '/', ' ', '$', '!','"' , '@'};
		boolean exist=false;
		boolean file_exist=true;
		int choice=0;
		String[] choices= new String[] {"Word Search", "Author Search", "Alphabetical Order of Authors", "Total word count per Post"};
		String exname="";
		String what_whom="";
		JFrame frame= new JFrame();
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////		
		try {
		choice= JOptionPane.showOptionDialog(null, "Which do you want to perform", "Method",
		        JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,
		        null, choices, choices[1]);
		exname =((String)JOptionPane.showInputDialog(
	            frame,
	            "Enter Name of Desired Output Text File (exclude .txt)",
	            "Export File Name",
	            JOptionPane.PLAIN_MESSAGE))+".txt";}
		catch(Exception c) {
					System.out.println("ERROR");
				};
			for(int j=0; j<illegalchar.length; j++) {
				for(int i=0; i<exname.length(); i++) {
					if(exname.charAt(i)==(illegalchar[j])) {
						file_exist=false;
					}
				}}
		try {
		      if (file_exist==false) {
		    	    blankL.setVerticalAlignment(JLabel.TOP);
		    	    blankL.setVerticalTextPosition(JLabel.TOP);
			        blankL.setText("<html> Because you did not enter a valid file name, I will shutdown.<br/> Goodbye!");
			        blankJ.setSize(400,200);
			        blankJ.setTitle("Shutting Down");
			        blankJ.getContentPane().add(blankL);
			        blankL.setFont(new Font("Serif", Font.PLAIN, 30));
			        blankJ.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			        blankJ.setVisible(true);
			        return;
		      }if (exname.equals(".txt")) {
		    	    blankL.setVerticalAlignment(JLabel.TOP);
		    	    blankL.setVerticalTextPosition(JLabel.TOP);
			        blankL.setText("<html> Because you did not enter a file name, I will shutdown.<br/> Goodbye!");
			        blankJ.setSize(400,200);
			        blankJ.setTitle("Shutting Down");
			        blankJ.getContentPane().add(blankL);
			        blankL.setFont(new Font("Serif", Font.PLAIN, 30));
			        blankJ.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			        blankJ.setVisible(true);
			        return;
		      }}
			  catch (Exception b) {
		        	//Create pop-up to announce an error has occurred with the zipcode
		        	errorL.setVerticalAlignment(JLabel.TOP);
			        errorL.setVerticalTextPosition(JLabel.TOP);
			        errorL.setText("I will now shutdown.  Please speak with me again!");
			        errorJ.setSize(500,100);
			        errorJ.setTitle("Closing Now");
			        errorJ.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			        errorJ.getContentPane().add(errorL);
			        errorL.setFont(new Font("Serif", Font.PLAIN, 20));
			        errorJ.setVisible(true);
			        return;}
		if (choice==0||choice==1) {
		what_whom = (String)JOptionPane.showInputDialog(
	            frame,
	            "Enter word or name you wish to search",
	            "Searcher",
	            JOptionPane.PLAIN_MESSAGE);
		}
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		if(choice==0) {
			String[][] every= everything();
			String[] words=new String[every.length];
			for (int j=0; j<every.length; j++) {
				words[j]=every[j][1];
			}
			for(int i= 0; i<words.length; i++) {
				if(what_whom.equals(words[i])) {
					exist=true;
				}
			}
			try {
			      if (exist==false) {
			    	    blankL.setVerticalAlignment(JLabel.TOP);
			    	    blankL.setVerticalTextPosition(JLabel.TOP);
				        blankL.setText("<html> The word you entered was not found. So I will shut down. <br/> Goodbye!");
				        blankJ.setSize(400,200);
				        blankJ.setTitle("Shutting Down");
				        blankJ.getContentPane().add(blankL);
				        blankL.setFont(new Font("Serif", Font.PLAIN, 30));
				        blankJ.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				        blankJ.setVisible(true);
				        return;
			      }}
				  catch (Exception b) {
			        	//Create pop-up to announce an error has occurred with the zipcode
			        	errorL.setVerticalAlignment(JLabel.TOP);
				        errorL.setVerticalTextPosition(JLabel.TOP);
				        errorL.setText("An error has occured, so I will now shutdown.  Please speak with me again!");
				        errorJ.setSize(500,100);
				        errorJ.setTitle("Closing Now");
				        errorJ.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				        errorJ.getContentPane().add(errorL);
				        errorL.setFont(new Font("Serif", Font.PLAIN, 20));
				        errorJ.setVisible(true);
				        return;}
			String[][] results=searcher(what_whom);
			try {
				String formatStr = "%-25s %-30s %-30s %-30s%n";
				PrintWriter writer = new PrintWriter(exname);
				for (int i=0; i< results.length; i++) {
					writer.println(String.format(formatStr,results[i][0], results[i][1],results[i][2],results[i][3]));
				}
				writer.close();
				}catch(Exception c) {
					errorL.setVerticalAlignment(JLabel.TOP);
			        errorL.setVerticalTextPosition(JLabel.TOP);
			        errorL.setText("An error has occured, so I will now shutdown.  Please speak with me again!");
			        errorJ.setSize(500,100);
			        errorJ.setTitle("Closing Now");
			        errorJ.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			        errorJ.getContentPane().add(errorL);
			        errorL.setFont(new Font("Serif", Font.PLAIN, 20));
			        errorJ.setVisible(true);
			        return;
				};
		}
///////////////////////////////////////////////////////////////////////////////////////////////////////////////
		if(choice==1) {
			String[] authors=names();
			for(int i= 0; i<authors.length; i++) {
				if(what_whom.equals(authors[i])) {
					exist=true;
				}
			}
			try {
			      if (exist==false) {
			    	    blankL.setVerticalAlignment(JLabel.TOP);
			    	    blankL.setVerticalTextPosition(JLabel.TOP);
				        blankL.setText("<html> The author you entered was not found. So I will shut down. <br/> Goodbye!");
				        blankJ.setSize(400,200);
				        blankJ.setTitle("Shutting Down");
				        blankJ.getContentPane().add(blankL);
				        blankL.setFont(new Font("Serif", Font.PLAIN, 30));
				        blankJ.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				        blankJ.setVisible(true);
				        return;
			      }}
				  catch (Exception b) {
			        	//Create pop-up to announce an error has occurred with the zipcode
			        	errorL.setVerticalAlignment(JLabel.TOP);
				        errorL.setVerticalTextPosition(JLabel.TOP);
				        errorL.setText("An error has occured, so I will now shutdown.  Please speak with me again!");
				        errorJ.setSize(500,100);
				        errorJ.setTitle("Closing Now");
				        errorJ.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				        errorJ.getContentPane().add(errorL);
				        errorL.setFont(new Font("Serif", Font.PLAIN, 20));
				        errorJ.setVisible(true);
				        return;}
			String[][] results=Asearcher(what_whom);
			try {
				String formatStr = "%-25s %-30s %-30s %-30s%n";
				PrintWriter writer = new PrintWriter(exname);
				for (int i=0; i< results.length; i++) {
					writer.println(String.format(formatStr,results[i][0], results[i][1],results[i][2],results[i][3]));
				}
				writer.close();
				}catch(Exception c) {
					errorL.setVerticalAlignment(JLabel.TOP);
			        errorL.setVerticalTextPosition(JLabel.TOP);
			        errorL.setText("An error has occured, so I will now shutdown.  Please speak with me again!");
			        errorJ.setSize(500,100);
			        errorJ.setTitle("Closing Now");
			        errorJ.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			        errorJ.getContentPane().add(errorL);
			        errorL.setFont(new Font("Serif", Font.PLAIN, 20));
			        errorJ.setVisible(true);
			        return;
				};
		}
////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		if(choice==2) {
			String[] authors=eachauthor();
			try {
				PrintWriter writer = new PrintWriter(exname);
				for (int i=0; i< authors.length; i++) {
				writer.println(authors[i]);
				}
				writer.close();
				}catch(Exception c) {
					errorL.setVerticalAlignment(JLabel.TOP);
			        errorL.setVerticalTextPosition(JLabel.TOP);
			        errorL.setText("An error has occured, so I will now shutdown.  Please speak with me again!");
			        errorJ.setSize(500,100);
			        errorJ.setTitle("Closing Now");
			        errorJ.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			        errorJ.getContentPane().add(errorL);
			        errorL.setFont(new Font("Serif", Font.PLAIN, 20));
			        errorJ.setVisible(true);
			        return;
				};}
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		if (choice==3) {
				String [][] Basic_summary=basic();
		try {
			String formatStr = "%-5s %-30s %-30s %-30s %-25s%n";
			PrintWriter writer = new PrintWriter(exname);
			for (int i=0; i< Basic_summary.length; i++) {
			writer.println(String.format(formatStr,Basic_summary[i][0], Basic_summary[i][1],Basic_summary[i][2],Basic_summary[i][3],Basic_summary[i][4]));
			}
			
			writer.close();
			}catch(Exception c) {
				errorL.setVerticalAlignment(JLabel.TOP);
		        errorL.setVerticalTextPosition(JLabel.TOP);
		        errorL.setText("An error has occured, so I will now shutdown.  Please speak with me again!");
		        errorJ.setSize(500,100);
		        errorJ.setTitle("Closing Now");
		        errorJ.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		        errorJ.getContentPane().add(errorL);
		        errorL.setFont(new Font("Serif", Font.PLAIN, 20));
		        errorJ.setVisible(true);
		        return;
			};}
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		    	    closeL.setVerticalAlignment(JLabel.TOP);
		    	    closeL.setVerticalTextPosition(JLabel.TOP);
		    	    closeL.setText("<html> Your data has been saved under the inputted file name. <br/> Goodbye!");
		    	    closeJ.setSize(400,200);
		    	    closeJ.setTitle("Shutting Down");
		    	    closeJ.getContentPane().add(closeL);
		    	    closeL.setFont(new Font("Serif", Font.PLAIN, 30));
		    	    closeJ.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		    	    closeJ.setVisible(true);
	}
		}