

import java.sql.*;
import java.util.ArrayList;

import javax.swing.JOptionPane;


public class Final {

	static int noOfSymptoms=184;
	static int findHighOccSymp[]=new int[noOfSymptoms];
	static int findHighAssSymp[]=new int[noOfSymptoms];
	static int arrForAss[]=new int[noOfSymptoms];
	static int arrForPast[]=new int[noOfSymptoms];
	static ArrayList<String> sympArr = new ArrayList<String>();
	static ArrayList<String> sympArrForYes = new ArrayList<String>();
	static int sympArrIndex=0;
	static int maxIndex;
	static int max;
	static String maxsympstr,maxsympstr4frame,First;
	static String pass="ashwin123";
	static int mainCount=0,assCount=0,Count=0;
	
	
	public static void main(String[] args)throws Exception		
	{
		/*for(int i=0;i<demo.length;i++){
			String str=demo[i];
			storeTheSymps(str);
		}
		
		for(int i=0;i<sympArr.size();i++){
			System.out.println(sympArr.get(i));
		}
		*/
		
	}
	
	public void forNewSymp(String symptom){
		try {
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/db1","root",pass);
			PreparedStatement st = con.prepareStatement("ALTER TABLE symptoms  ADD "+symptom+" INT DEFAULT 0");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Error! Symptoms could not be added");
		}
		
	}
	
	
	public void generateAss() throws SQLException{
		
		deletePrev(); 										// here add queries to drop previous table a create a new association table.
		
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/db1","root",pass);
		
		PreparedStatement st=con.prepareStatement("SELECT * from symptoms");
		ResultSet rs=st.executeQuery();
		ResultSetMetaData rsmd = rs.getMetaData();
	
		
		for(int i=2;i<=185;i++)
		{
			String temp=rsmd.getColumnLabel(i);
			
			PreparedStatement st1=con.prepareStatement("SELECT * FROM symptoms WHERE `"+temp+"` = 1");
			
			ResultSet rs1=st1.executeQuery();
			//ResultSetMetaData rsmd1 = rs1.getMetaData();
			
			for(int ii=0;ii<arrForAss.length;ii++){
				arrForAss[ii]=0;
				}
			
			while(rs1.next())													//to find the sum of all symptoms, to eventually store in arrForAss.											
			{
				for(int a=0,j=2;a<arrForAss.length;a++,j++)						//*****put a condition for not including values of 'temp' eg. high_fever.
				{
					arrForAss[a]+=rs1.getInt(j);
					
				}
				
			}
			//System.out.println(temp);
			
			insert(temp);
			System.out.println("Done"+(i-1)+"%");
		}
		
		remRedundancy();
		
		
	
	}
	
	private static void deletePrev() throws SQLException {
		
		System.out.println("Deleting previous records.....");
		
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/demo","root",pass);
		PreparedStatement st=con.prepareStatement("SELECT * from associate",ResultSet.TYPE_SCROLL_SENSITIVE,
                ResultSet.CONCUR_UPDATABLE);
		ResultSet rsRed=st.executeQuery();
		ResultSetMetaData rsmdRed = rsRed.getMetaData();
		
		for(int i=2;i<=31;i++){
			
			String temp=rsmdRed.getColumnLabel(i);
			
			rsRed.beforeFirst();
			while(rsRed.next()){
				
				if(rsRed.getString(1).equals(temp)){
					
					rsRed.deleteRow();
				}
			}
		}
		System.out.println("Done ! Your previous Association table has been deleted");
		
		
	}

	public static void insert(String temp) throws SQLException{
		
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/demo","root",pass);
	
		
			PreparedStatement st=con.prepareStatement("INSERT INTO associate(symptoms) VALUES('"+temp+"')");
			st.executeUpdate();
		
			PreparedStatement st0=con.prepareStatement("SELECT * from associate",ResultSet.TYPE_SCROLL_SENSITIVE,
	                ResultSet.CONCUR_UPDATABLE);
			ResultSet rs1=st0.executeQuery();
			
			int count=1;
			while(rs1.next()){
				
				if(rs1.getString(1).equals(temp))
				{
					break;
				}
				else
					count+=1;
				
			}
			
			
			rs1.absolute(count);
			for(int i=0;i<30;i++)
			{
				rs1.updateInt(i+2,arrForAss[i]);
				rs1.updateRow();
				//System.out.print(+rs1.getInt(i+2));
			}
			System.out.println();
			
		
	}
	
	public static void remRedundancy() throws SQLException{
		
		System.out.println("Removing Redundancies");
		
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/demo","root",pass);
		PreparedStatement st=con.prepareStatement("SELECT * from associate",ResultSet.TYPE_SCROLL_SENSITIVE,
                ResultSet.CONCUR_UPDATABLE);
		ResultSet rsRed=st.executeQuery();
		ResultSetMetaData rsmdRed = rsRed.getMetaData();
		
		for(int i=2;i<=31;i++){
			
			String temp=rsmdRed.getColumnLabel(i);
			
			rsRed.beforeFirst();
			while(rsRed.next()){
				
				if(rsRed.getString(1).equals(temp)){
					rsRed.updateInt(temp,0);
					rsRed.updateRow();
				}
			}
		}
		System.out.println("Done ! You are ready with the Association table !");
		
	}
	
	
	
	public void forPastSymptoms(String usern) throws SQLException{
		
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/db1","root",pass);
		
		PreparedStatement st=con.prepareStatement("SELECT * from symphistory");
		
		ResultSet rs=st.executeQuery();
		ResultSetMetaData rsmd=rs.getMetaData();
		
		while(rs.next())
		{
			if(rs.getString(1).equals(usern))
			{
				
				for(int i=0,j=2;i<arrForPast.length;i++,j++)//to store the sum of all symptoms in an array.
				{
					arrForPast[i]=rs.getInt(j);
					
				}
				break;
				
			}
			
			
		}
		
		
		int index=getPastSymp();
		if(index==9999){
			Frame26 f=new Frame26(usern);
			
			f.setVisible(true);
		}
		else{
		String str=rsmd.getColumnLabel(index+2);
		
		str=str.replace('_',' ');
		
		Frame25 f=new Frame25(str,usern);
		
		f.setVisible(true);
		
		}
		
	}
	
	
	public int getPastSymp() throws SQLException{
		
		int index=9999;
		for(int i=0;i<noOfSymptoms;i++)							//to calculate the max sum (occurring element) in the database.
		{
			if(arrForPast[i]==1)
			{	
				index=i;
				break;						//stores the column index of the max occurring symptom.
			}
		}
		if(index!=9999)
			arrForPast[index]=0;
		return index;
		
		
	}
	
	
	
	public void forNoPast(String usern) throws SQLException{
		
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/db1","root",pass);
		
		PreparedStatement st=con.prepareStatement("SELECT * from symphistory");
		
		ResultSet rs=st.executeQuery();
		ResultSetMetaData rsmd=rs.getMetaData();
		
		int index=getPastSymp();
		if(index==9999){
			Frame26 f=new Frame26(usern);
			
			f.setVisible(true);
		}
		else{
		String str=rsmd.getColumnLabel(index+2);
		
		str=str.replace('_',' ');
		
		Frame25 f=new Frame25(str,usern);
		
		f.setVisible(true);
		}
	}
	
	
	public void forYesPastSymp(String str,String username) throws SQLException{
		
		String disease="",treatment="";
		str=str.replace(' ','_');
		
		Count+=1;
		
		//create a view with that symp=1.
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/db1","root",pass);
		if(Count==1){
		
		PreparedStatement st=con.prepareStatement("CREATE VIEW filter"+Count+" AS SELECT * FROM symptoms WHERE `"+str+"` = 1",ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_UPDATABLE);
		
		st.execute();
		}
		else{
			
			PreparedStatement st=con.prepareStatement("CREATE VIEW filter"+Count+" AS SELECT * FROM filter"+(Count-1)+" WHERE `"+str+"` = 1",ResultSet.TYPE_SCROLL_INSENSITIVE,
	                ResultSet.CONCUR_UPDATABLE);
			
			st.execute();
		}
		
		
		//filter the symp table.
		PreparedStatement st1=con.prepareStatement("SELECT * from filter"+Count);
		ResultSet rs=st1.executeQuery();
		int count=0;
		while(rs.next())
		{
			//System.out.println(rs.getInt(1));
			count++;
		}
		
		if(count==1)
		{
			rs.previous();
			int id=rs.getInt(1);
			PreparedStatement st2=con.prepareStatement("SELECT * from disease_treatment");
			ResultSet rs2=st2.executeQuery();
			
			while(rs2.next()){
				if(rs2.getInt(1)==id){
					disease=rs2.getString(2);
					treatment=rs2.getString(3);
				}
			}
					
			for(int i=1;i<=Count;i++){//to delete all views
				PreparedStatement st0=con.prepareStatement("DROP VIEW filter"+i,ResultSet.TYPE_SCROLL_INSENSITIVE,
		                ResultSet.CONCUR_UPDATABLE);
				
				st0.execute();
			}
			
			/*for(int ii=0;ii<sympArr.size();ii++){
				sympArr.add("NULL");
		}*/

			
			//display correct disease and treatment.
			Frame22 f4_main=new Frame22(disease,treatment,username,sympArrForYes);
			f4_main.setVisible(true);
			
				
		
		}//end of if
		
		else{
			forNoPast(username);
		}

		
		
		
	}
	
	
	
	
	public void findMAxSympInitial(String username)throws Exception
	{
		sympArr.clear();
		mainCount=0;
		for(int i=0;i<findHighOccSymp.length;i++){
			findHighOccSymp[i]=0;
			}
		
		for(int i=0;i<findHighAssSymp.length;i++){
			findHighAssSymp[i]=0;
			}
		
		maxIndex=0;
		max=0;
		
		
		Class.forName("com.mysql.jdbc.Driver");
		
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/db1","root",pass);
		
		PreparedStatement st=con.prepareStatement("SELECT * from symptoms");
		
		ResultSet rs=st.executeQuery();
		
		while(rs.next())
		{
			for(int i=0,j=2;i<findHighOccSymp.length;i++,j++)//to store the sum of all symptoms in an array.
			{
				findHighOccSymp[i]+=rs.getInt(j);
				
			}
			
		}
		int mi=indexOfMaxSymp();
		
		ResultSetMetaData rsmd=rs.getMetaData();	
		
		maxsympstr=rsmd.getColumnLabel(mi+2);
		
		maxsympstr4frame=maxsympstr.replace('_',' ');
		
		Frame20 f2_4mmain=new Frame20(maxsympstr4frame,username);
		
		f2_4mmain.setVisible(true);
		
	}
	
	public int indexOfMaxSymp() 
	{
			max=0;
			for(int i=0;i<noOfSymptoms;i++)							//to calculate the max sum (occurring element) in the database.
			{
				if(findHighOccSymp[i]>max&&(findHighOccSymp[i]!=0))
				{
					max=findHighOccSymp[i];
					maxIndex=i;								//stores the column index of the max occurring symptom.
				}
			}
			findHighOccSymp[maxIndex]=0;
			if(max==0){
				return 9999;
			}
			else
			return maxIndex;
			
			
			
	}	
		
	public void forNoSymp(String str,String username) throws SQLException
	{
		str=str.replace(' ','_');
		storeTheSymps(str);
		//dontAskThatSympAgain(str);
		
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/db1","root",pass);
		
		PreparedStatement st=con.prepareStatement("SELECT * from symptoms");
		
		ResultSet rs=st.executeQuery();
		
		int mi=indexOfMaxSymp();
		
		if(mi==9999)
		{
			Frame23 f=new Frame23(username);
			f.setVisible(true);
		}
	
		else{
		ResultSetMetaData rsmd=rs.getMetaData();	
		
		maxsympstr=rsmd.getColumnLabel(mi+2);
		
		maxsympstr4frame=maxsympstr.replace('_',' ');
		
		Frame20 f2_4mmain=new Frame20(maxsympstr4frame,username);
		
		f2_4mmain.setVisible(true);
		}	
			
	}
	
	
	public void toFindAss(String str,String username) throws SQLException
	{
		//str=str.replace(' ','_');
		
		
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/db1","root",pass);
		
		PreparedStatement st=con.prepareStatement("SELECT * from association");
		
		ResultSet rs=st.executeQuery();
		ResultSetMetaData rsmd=rs.getMetaData();
		
		while(rs.next())
		{
			if(rs.getString(1).equals(str))
			{
				
				for(int i=0,j=2;i<findHighAssSymp.length;i++,j++)//to store the sum of all symptoms in an array.
				{
					findHighAssSymp[i]=rs.getInt(j);
					
				}
				break;
				
			}
			
			
		}
		findMaxDispSymp(rsmd,username);
		
	}
	public void findMaxDispSymp(ResultSetMetaData rsmd,String username) throws SQLException
	{
		int flag=0;
		
		int mi=nextHighestAss();
			
		
		maxsympstr=rsmd.getColumnLabel(mi+2);
		for(int i=0;i<sympArr.size();i++){
			
			if(maxsympstr.equals(sympArr.get(i))){
				flag=1;
				
			}
		}
		
		if(flag==1){
			findMaxDispSymp(rsmd,username);
		}
		else{
			
		
		maxsympstr4frame=maxsympstr.replace('_',' ');
		/*System.out.print(maxsympstr);*/
		
		Frame21 f3_4mmain=new Frame21(maxsympstr4frame,username);
		
		f3_4mmain.setVisible(true);
		}	
			
	}
	
	
	
	public int nextHighestAss(){
		int mi=0;
		max=0;
		for(int i=0;i<noOfSymptoms;i++)							//to calculate the max sum (occurring element) in the database.
		{
			if(findHighAssSymp[i]>max&&findHighAssSymp[i]!=0)
			{
				max=findHighAssSymp[i];
				mi=i;								//stores the column index of the max occurring symptom.
			}
		}
		
		
		
		findHighAssSymp[mi]=0;
		
		
		return mi;
	}
	
	
	public void forNoAss(String str,String username) throws SQLException
	{
		//int flag=0;
		str=str.replace(' ','_');
		storeTheSymps(str);
		//dontAskThatSympAgain(str);
		
		//int mi=nextHighestAss();
		
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/db1","root",pass);
		
		PreparedStatement st=con.prepareStatement("SELECT * from association");
		ResultSet rs=st.executeQuery();
	
		ResultSetMetaData rsmd=rs.getMetaData();	
		
		findMaxDispSymp(rsmd,username);
		
		/*maxsympstr=rsmd.getColumnLabel(mi+2);
		
		for(int i=0;i<sympArr.size();i++){
			
			if(maxsympstr4frame.equals(sympArr.get(i))){
				flag=1;
			
			}
		}
		
		if(flag==1){
			forNoAss(str);
		}
		
		else{
		maxsympstr4frame=maxsympstr.replace('_',' ');
		
		System.out.println(maxsympstr4frame);
		
		frame3 f3_4mmain=new frame3(maxsympstr4frame);
		
		f3_4mmain.setVisible(true);
		}*/
	}	
	
	
	
	
	public void finalForYes(String str,String username) throws SQLException{
		
		String disease="",treatment="";
		sympArrForYes.add(str);
		
		str=str.replace(' ','_');
		
		mainCount+=1;
		System.out.println(mainCount);
	
		
		
		storeTheSymps(str);//for not asking the symptoms again
		
		
		//create a view with that symp=1.
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/db1","root",pass);
		if(mainCount==1){
		
		PreparedStatement st=con.prepareStatement("CREATE VIEW filter"+mainCount+" AS SELECT * FROM symptoms WHERE `"+str+"` = 1",ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_UPDATABLE);
		
		st.execute();
		}
		else{
			
			PreparedStatement st=con.prepareStatement("CREATE VIEW filter"+mainCount+" AS SELECT * FROM filter"+(mainCount-1)+" WHERE `"+str+"` = 1",ResultSet.TYPE_SCROLL_INSENSITIVE,
	                ResultSet.CONCUR_UPDATABLE);
			
			st.execute();
		}
		
		
		//filter the symp table.
		PreparedStatement st1=con.prepareStatement("SELECT * from filter"+mainCount);
		ResultSet rs=st1.executeQuery();
		int count=0;
		while(rs.next())
		{
			//System.out.println(rs.getInt(1));
			count++;
		}
		
		if(count==0)
		{
			for(int i=1;i<=mainCount;i++){//to delete all views
				PreparedStatement st0=con.prepareStatement("DROP VIEW filter"+i,ResultSet.TYPE_SCROLL_INSENSITIVE,
		                ResultSet.CONCUR_UPDATABLE);
				st0.execute();
				
				
			}
			
			Frame27 f=new Frame27(username);
			f.setVisible(true);
		}
		
		
		else if(count==1)
		{
			rs.previous();
			int id=rs.getInt(1);
			PreparedStatement st2=con.prepareStatement("SELECT * from disease_treatment");
			ResultSet rs2=st2.executeQuery();
			
			while(rs2.next()){
				if(rs2.getInt(1)==id){
					disease=rs2.getString(2);
					treatment=rs2.getString(3);
				}
			}
					
			for(int i=1;i<=mainCount;i++){//to delete all views
				PreparedStatement st0=con.prepareStatement("DROP VIEW filter"+i,ResultSet.TYPE_SCROLL_INSENSITIVE,
		                ResultSet.CONCUR_UPDATABLE);
				
				st0.execute();
			}
			
			/*for(int ii=0;ii<sympArr.size();ii++){
				sympArr.add("NULL");
		}*/

			
			//display correct disease and treatment.
			Frame22 f4_main=new Frame22(disease,treatment,username,sympArrForYes);
			f4_main.setVisible(true);
			
			
			
			
			
		
		}
		
		else
		{
			toFindAss(str,username);
						
		}

		
		
		
	}


	public static void storeTheSymps(String str){
		
		sympArr.add(str);
		
		
		
	}
	
	
	
	
}
