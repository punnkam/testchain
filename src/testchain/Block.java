package testchain;

import java.util.Date;

public class Block {
    
    
    // Basic structure of a block
    public String hash;
    public String prevHash;
    private String data;        // In a real block, data will be an object with many fields
    private long timeStamp;     // UNIX format
    private int nonce;
    
    
    public Block(String data, String prevHash) {
        this.data = data;
        this.prevHash = prevHash;
        this.timeStamp = new Date().getTime();
        this.hash = calculateHash();
        
    }
    
    
    // Calculate the current has of the block
    public String calculateHash() {
        
        // Elements that go into the hash function are prevHash, current time, and data
        return StringUtil.sha256(prevHash + Long.toString(timeStamp) + data);
    }
    
    // Mining blocks given difficulty level (number of zeroes preceding hash)
    public void mineBlock(int difficulty) {
        String target = new String(new char[difficulty]).replace('\0', '0');
        while(!hash.substring(0, difficulty).equals(target)) {
            nonce++;
            hash = calculateHash();
        }
        
        System.out.println("Mined block with hash: " + hash);
    }
    
}
