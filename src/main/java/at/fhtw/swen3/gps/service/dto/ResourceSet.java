package at.fhtw.swen3.gps.service.dto;

import java.util.ArrayList;

public class ResourceSet {
    public int estimatedTotal;
    public ArrayList<Resource> resources;

    @Override
    public String toString() {
        // Build the string representation of the object
        StringBuilder sb = new StringBuilder();
        sb.append("ResourceSet {");
        sb.append("estimatedTotal=").append(estimatedTotal).append(", ");
        sb.append("resources=[");
        for (int i = 0; i < resources.size(); i++) {
            sb.append(resources.get(i).toString());
            if (i < resources.size() - 1) {
                sb.append(", ");
            }
        }
        sb.append("]}");
        return sb.toString();
    }
}
