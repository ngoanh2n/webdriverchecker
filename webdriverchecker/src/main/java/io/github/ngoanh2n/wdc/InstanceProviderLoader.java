package io.github.ngoanh2n.wdc;

import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * @author Ho Huu Ngoan (ngoanh2n@gmail.com)
 * @version 1.0.0
 * @since 2021-04-10
 */
class InstanceProviderLoader {

    static synchronized InstanceProvider load() {
        ServiceLoader<InstanceProvider> service = ServiceLoader.load(InstanceProvider.class);
        Iterator<InstanceProvider> serviceLoaders = service.iterator();

        if (serviceLoaders.hasNext()) {
            return serviceLoaders.next();
        } else {
            throw new IllegalStateException("No implementation of InstanceProvider provided");
        }
    }
}
