package io.github.ngoanh2n.wdc;

import org.slf4j.Logger;

import java.util.Iterator;
import java.util.ServiceLoader;

import static org.slf4j.LoggerFactory.getLogger;

/**
 * @author Ho Huu Ngoan (ngoanh2n@gmail.com)
 * @version 1.0.0
 * @since 2021-04-10
 */
class InstanceProviderLoader {

    private static final Logger LOGGER = getLogger(InstanceProviderLoader.class);

    static synchronized InstanceProvider load() {
        ServiceLoader<InstanceProvider> service = ServiceLoader.load(InstanceProvider.class);
        Iterator<InstanceProvider> serviceLoaders = service.iterator();

        if (!serviceLoaders.hasNext()) {
            throw new IllegalStateException("No implementation of InstanceProvider provided");
        } else {
            InstanceProvider implementation = serviceLoaders.next();
            LOGGER.info("Using implementation of {}: {}", InstanceProvider.class.getName(), implementation.getClass().getName());
            return implementation;
        }
    }
}
