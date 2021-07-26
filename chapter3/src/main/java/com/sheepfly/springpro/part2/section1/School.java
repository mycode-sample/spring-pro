package com.sheepfly.springpro.part2.section1;

public class School implements ManagedComponent {
    private Company company;

    @Override
    public void doSearch(Container container) {
        this.company = (Company) container.getDependency("company");
    }
}
