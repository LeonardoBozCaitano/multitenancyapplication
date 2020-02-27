package br.com.multitenancy.core;

public class CurrentContext {

    private static ThreadLocal<String> tenant = new ThreadLocal<>();

    public static void setTenantName(String tenantName) {
        tenant.set(tenantName);
    }

    public static String getTenantName() {
        return tenant.get();
    }
}
