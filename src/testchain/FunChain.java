package testchain;

import java.util.ArrayList;

public class FunChain {
    public static ArrayList<Block> blockchain = new ArrayList<Block>();
    
    public static void main(String[] args) {
        
        blockchain.add(new Block("This is the first block", "0")) ;
        blockchain.add(new Block("This is the second block",blockchain.get(blockchain.size()-1).hash)); 
        blockchain.add(new Block("This is the third block",blockchain.get(blockchain.size()-1).hash));

    }
    
    // Check whether the chain is invalid by checking the curr and prev hashes
    public static boolean isValid() {
        Block curr;
        Block prev;
        
        for(int i=1; i<blockchain.size(); i++) {
            curr = blockchain.get(i);
            prev = blockchain.get(i-1);
            
            if(!curr.hash.equals(curr.calculateHash()) || !prev.hash.equals(curr.prevHash)){
                System.out.println("Current Hashes not equal");         
                return false;
            }
        }
        return true;
    }
    
    
}
