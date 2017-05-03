package com.tenmiles.utils;

import java.util.HashSet;
import java.util.Set;

import com.tenmiles.dto.TaskDuration;
import com.tenmiles.model.TaskDurEO;

public class Utility {
    public static Set<TaskDuration> gettaskDurObj(Set<TaskDurEO> durationSet) {
        Set<TaskDuration> set = new HashSet<TaskDuration>();
        for (TaskDurEO dur : durationSet) {
            TaskDuration local = new TaskDuration();
            local.setDuration(dur.getDuration());
            local.setStartTimestamp(dur.getStarteTimestamp());
            local.setEndTimestamp(dur.getEndTimestamp());
            set.add(local);
        }
        return set;
    }
}
