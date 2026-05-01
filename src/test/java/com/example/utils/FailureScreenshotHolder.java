package com.example.utils;

/**
 * Holds the failure screenshot path between {@code @AfterMethod} (capture before quit)
 * and {@link TestListener#onTestFailure} (attach to Extent).
 */
public final class FailureScreenshotHolder {

    private static final ThreadLocal<String> PATH = new ThreadLocal<>();

    private FailureScreenshotHolder() {}

    public static void setLastFailureScreenshot(String absolutePath) {
        PATH.set(absolutePath);
    }

    /** Removes any stale path for this thread (call from listener start). */
    public static void clear() {
        PATH.remove();
    }

    /** Returns the path and clears it for this thread. */
    public static String takeLastFailureScreenshot() {
        try {
            return PATH.get();
        } finally {
            PATH.remove();
        }
    }
}
