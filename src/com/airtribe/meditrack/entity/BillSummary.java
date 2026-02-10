package com.airtribe.meditrack.entity;

public final class BillSummary {
    private final int totalBills;
    private final double totalRevenue;
    private final double avgBillAmount;

    public BillSummary(int totalBills, double totalRevenue, double avgBillAmount) {
        this.totalBills = totalBills;
        this.totalRevenue = totalRevenue;
        this.avgBillAmount = avgBillAmount;
    }

    // Only getters - Immutable
    public int getTotalBills() { return totalBills; }
    public double getTotalRevenue() { return totalRevenue; }
    public double getAvgBillAmount() { return avgBillAmount; }

    @Override
    public String toString() {
        return String.format("📊 Summary[Bills=%d, Revenue=₹%.2f, Avg=₹%.2f]",
                totalBills, totalRevenue, avgBillAmount);
    }
}
