package com.pwojczyn.HostStatsAgent.javasysmon;
/**
 * This is the interface that needs to be
 * implemented for any platform that JavaSysMon
 * supports. If you write your own implementation,
 * you can test it by injecting it into
 * {@link JavaSysMon#setMonitor}
 */
public interface Monitor {
    /**
     * Get the operating system name.
     *
     * @return The operating system name.
     */
    String osName();

    /**
     * Get the number of CPU cores.
     *
     * @return The number of CPU cores.
     */
    int numCpus();

    /**
     * Get the CPU frequency in Hz
     *
     * @return the CPU frequency in Hz
     */
    long cpuFrequencyInHz();

    /**
     * How long the system has been up in seconds.
     * Doesn't generally include time that the system
     * has been hibernating or asleep.
     *
     * @return The time the system has been up in seconds.
     */
    long uptimeInSeconds();

    /**
     * Gets a snapshot which contains the total amount
     * of time the CPU has spent in user mode, kernel mode,
     * and idle. Given two snapshots, you can calculate
     * the CPU usage during that time. There is a convenience
     * method to perform this calculation in
     * {@link CpuTimes#getCpuUsage}
     *
     * @return An object containing the amount of time the
     * CPU has spent idle, in user mode and in kernel mode,
     * in milliseconds.
     */
    CpuTimes cpuTimes();

    /**
     * Gets the physical memory installed, and the amount free.
     *
     * @return An object containing the amount of physical
     * memory installed, and the amount free.
     */
    MemoryStats physical();

    /**
     * Gets the amount of swap available to the operating system,
     * and the amount that is free.
     *
     * @return An object containing the amount of swap available
     * to the system, and the amount free.
     */
    MemoryStats swap();

    /**
     * Gets the pid of the process that is calling this method
     * (assuming it is running in the same process).
     *
     * @return The pid of the process calling this method.
     */
    int currentPid();

    /**
     * Get the current process table. This call returns an array of
     * objects, each of which represents a single process.
     *
     * @return An array of objects, each of which represents a process.
     */
    ProcessInfo[] processTable();

    /**
     * Attempts to kill the process identified by the integer id supplied.
     * This will silently fail if you don't have the authority to kill
     * that process. This method sends SIGTERM on the UNIX platform,
     * and kills the process using TerminateProcess on Windows.
     *
     * @param pid The id of the process to kill
     */
    void killProcess(int pid);
}
