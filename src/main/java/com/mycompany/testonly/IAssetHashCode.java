/*
 *
 */
package com.mycompany.testonly;

/**
 *
 * @author codetime
 */
public interface IAssetHashCode {
    public int getHashCode(String assetCode) throws Exception;
    public int getHashCode(String assetCode, int hash_size) throws Exception;
}
