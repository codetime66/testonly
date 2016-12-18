/*
 * 
 */
package com.mycompany.testonly;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author codetime
 */
public class AssetHashCode implements IAssetHashCode {

    final int len = 11;
    final int hash_size = 524288;

    public AssetHashCode() { }

    @Override
    public int getHashCode(String assetCode) throws Exception {
        return getHashCode(assetCode, 0);
    }

    @Override
    public int getHashCode(String assetCode, int hash_size) throws Exception {
        if (assetCode==null || assetCode.length() != len) {
            throw new Exception("invalid asset code length: the code have to be assembled using 11 characters");
        }        
        int h = 0;
        char val[] = assetCode.toCharArray();
        for (int i = 0; i < len; i++) {
            h = (h * 37) + val[i];
            if (h < 0) {
                h *= -1;
            }
        }
        h = (hash_size > 0) ? h % hash_size : h % this.hash_size;
        return h;
    }

    public static void main(String[] args) {
        try {
            IAssetHashCode chc;
            chc = new AssetHashCode();
            int h = chc.getHashCode(args[0]);
            Logger.getLogger(AssetHashCode.class.getName()).log(Level.INFO, "hash: {0}", h);
        } catch (Exception ex) {
            Logger.getLogger(AssetHashCode.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
