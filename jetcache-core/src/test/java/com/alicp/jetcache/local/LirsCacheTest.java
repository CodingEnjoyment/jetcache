/**
 * Created on  13-09-24 10:20
 */
package com.alicp.jetcache.local;

import com.alicp.jetcache.cache.Cache;
import com.alicp.jetcache.cache.CacheBuilderConfig;
import com.alicp.jetcache.support.CacheConfig;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import java.util.function.Function;

/**
 * @author <a href="mailto:yeli.hl@taobao.com">huangli</a>
 */
@Ignore
public class LirsCacheTest extends AbstractLocalCacheTest {

    @Override
    protected Function<CacheBuilderConfig, Cache> getBuildFunc() {
        return (c) -> new LirsCache((LocalCacheConfig) c);
    }

    @Override
    @Test
    public void test1() throws Exception {
        super.test1();
    }

    @Override
    @Test
    public void testNull() {
        super.testNull();
    }

    public void testLirs() {
        LirsCache.LirsAreaCache c = new LirsCache.LirsAreaCache(2, 1, 10, false);
        c.putValue("1", 1);
        c.putValue("2", 2);
        c.putValue("3", 3);
        c.putValue("4", 4);
        Assert.assertNotNull(c.getValue("1"));
        Assert.assertNotNull(c.getValue("2"));
        Assert.assertNull(c.getValue("3"));
        Assert.assertNotNull(c.getValue("4"));
    }

    @Override
    @Test
    public void testConcurrent() throws Exception {
        super.testConcurrent();
    }
}