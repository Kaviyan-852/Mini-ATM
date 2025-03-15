
package BACKEND;
import POJOS.Pojo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class QURIES {
    
    
    public boolean createAcc(POJOS.Pojo po){
    
    try{
    
        CONNECTIONS con = new CONNECTIONS();
        Connection c = con.connects();
        
        PreparedStatement ps  =  c.prepareStatement("insert into atm (acc,pin,name,cif,address,acctype,phoneno,email) values (?,?,?,?,?,?,?,?)");
        ps.setLong(1, po.getAcc_no());
        ps.setShort(2, po.getPin_no());
        ps.setString(3, po.getName());
        ps.setLong(4, po.getCif());
        ps.setString(5, po.getAddress());
        ps.setString(6, po.getType());
        ps.setLong(7, po.getPhonenumber());
        ps.setString(8, po.getEmail());
        ps.executeUpdate();
     
        return true;
    }
       
    catch(Exception e){
    e.printStackTrace();
    }
    
      return false;  
    }
    

    public boolean logInCheck(POJOS.Pojo po){
    try{
        CONNECTIONS con = new CONNECTIONS();
        Connection c = con.connects();
        PreparedStatement ps  =  c.prepareStatement("Select acc,pin,amt,name from atm where acc = ? and pin = ?");
        ps.setLong(1, po.getAcc_no());
        ps.setShort(2, po.getPin_no());
        ResultSet rs = ps.executeQuery();
        if(rs.next()){
            
           po.setAmt(rs.getDouble("amt"));
           po.setName(rs.getString("name"));
            
          return true;
        }
    }  
    catch(Exception e){
    e.printStackTrace();
    }
       return false;
    }
    
    
    public boolean amount(POJOS.Pojo po){
    
        try{
        
          CONNECTIONS obj = new CONNECTIONS();
          Connection con = obj.connects();
          
       PreparedStatement ps  = con.prepareStatement("update atm set amt = ? where acc = ? ");
          
          ps.setDouble(1, po.getAmt());
          ps.setLong(2, po.getAcc_no());
          ps.executeUpdate();
          
        return true;
        }
        catch(Exception e){
        e.printStackTrace();
        }
    return false;
    }
    
    
    
       public double balAmt(POJOS.Pojo po){
    
        try{
        
          CONNECTIONS obj = new CONNECTIONS();
          Connection con = obj.connects();
          
       PreparedStatement ps  = con.prepareStatement("select amt from atm where acc = ?");
       
          ps.setDouble(1, po.getAcc_no());
        ResultSet rs = ps.executeQuery();
   
        if(rs.next()){
        
        return rs.getDouble("amt");
        }

        }
        catch(Exception e){
        e.printStackTrace();
        }
       return 0;
    }
    
       
       public double Credit(POJOS.Pojo po){
       
           try{
           
           CONNECTIONS obj = new CONNECTIONS();
           Connection con = obj.connects();
          PreparedStatement ps = con.prepareStatement("insert into history (credit,acc,balance) values (?,?,?)");
          ps.setDouble(1, po.getCredit());
          ps.setDouble(2, po.getAcc_no());
          ps.setDouble(3, po.getAmt());
          ps.executeUpdate();
          
           return po.getCredit();
           }
           catch(Exception e){
           e.printStackTrace();
           }
           
       return 0;
       }
       
       
         public double Debit(POJOS.Pojo po){
       
           try{
           
           CONNECTIONS obj = new CONNECTIONS();
           Connection con = obj.connects();
          PreparedStatement ps = con.prepareStatement("insert into history (debit,acc,balance) values (?,?,?)");
          ps.setDouble(1, po.getDebit());
          ps.setDouble(2, po.getAcc_no());
          ps.setDouble(3, po.getAmt());
          ps.executeUpdate();
          
           return po.getDebit();
           }
           catch(Exception e){
           e.printStackTrace();
           }
           
       return 0;
       }
         
      public ArrayList<POJOS.Pojo> showStatement(POJOS.Pojo poj){
      try{
      CONNECTIONS obj = new CONNECTIONS();
      Connection con = obj.connects();
      PreparedStatement ps = con.prepareStatement("SELECT history.debit,history.credit,history.balance,history.trans FROM atm inner join history on atm.acc=history.acc where history.acc = ?");
      ps.setLong(1, poj.getAcc_no());
      ResultSet rs =   ps.executeQuery();
      ArrayList <POJOS.Pojo>list = new ArrayList<>();
      while(rs.next()){
      POJOS.Pojo po = new Pojo();
      po.setCredit(rs.getDouble("credit"));
      po.setDebit(rs.getDouble("debit"));
      po.setTran(rs.getTimestamp("trans"));
      po.setBal(rs.getDouble("balance"));
      list.add(po);
      }
      return list;
      }
      catch(Exception e){
      e.printStackTrace();
      }
      return null;
      }
          
      
      public void details(POJOS.Pojo po){
      
      try{
      
           CONNECTIONS obj = new CONNECTIONS();
           Connection con =  obj.connects();
           PreparedStatement ps = con.prepareStatement("select name,cif,address,acctype,phoneno,email from atm where acc = ?");
           ps.setDouble(1, po.getAcc_no());
          ResultSet rs = ps.executeQuery();
           if(rs.next()){
           po.setName(rs.getString("name"));
           po.setCif(rs.getLong("cif"));
           po.setType(rs.getString("acctype"));
           po.setAddress(rs.getString("address"));
           po.setPhonenumber(rs.getLong("phoneno"));
           po.setEmail(rs.getString("email"));
               
           }
           
      
      }
        catch(Exception e){
        
        e.printStackTrace();
        
        }  
          

      }
      
      public boolean changePin(Pojo po){
     
          try{
          
           CONNECTIONS c  = new CONNECTIONS();
           Connection con = c.connects();
           PreparedStatement ps = con.prepareStatement("update atm set pin = ? where acc = ?");
           ps.setShort(1, po.getPin_no());
           ps.setLong(2, po.getAcc_no());
           ps.executeUpdate();
    
           return true;
          }
          catch(Exception e){
          
          e.printStackTrace();
              
          }
          
      return false;
      }
      
      
      
      public void clear(Pojo p){
      
          try{
          Pojo po = new Pojo();
           CONNECTIONS c = new CONNECTIONS();
            Connection con  =   c.connects();
            PreparedStatement ps = con.prepareStatement("delete from history where acc = ?");
            ps.setLong(1, po.getAcc_no());
            ps.executeUpdate();
          }
          catch(Exception e){
          e.printStackTrace();
          }
      
      
      }
      
      
}
