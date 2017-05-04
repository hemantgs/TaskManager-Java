package com.tenmiles.utils;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import com.tenmiles.dto.TaskDuration;
import com.tenmiles.model.TaskDurEO;

public class Utility {
    public static Set<TaskDuration> gettaskDurObj(Set<TaskDurEO> durationSet) {
        Set<TaskDuration> set = new HashSet<TaskDuration>();
        for (TaskDurEO dur : durationSet) {
            long hh = TimeUnit.MILLISECONDS.toHours(dur.getDuration());
            long mm = TimeUnit.MILLISECONDS.toMinutes(dur.getDuration())
                    - TimeUnit.HOURS.toMinutes(hh);
            TaskDuration local = new TaskDuration();
            local.setDuration(dur.getDuration());
            local.setTimeGap(String.valueOf(hh) +":"+ String.valueOf(mm));
            local.setStartTimestamp(dur.getStarteTimestamp());
            local.setEndTimestamp(dur.getEndTimestamp());
            set.add(local);
        }
        return set;
    }
}
