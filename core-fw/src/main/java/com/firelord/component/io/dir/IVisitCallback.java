package com.firelord.component.io.dir;

import java.io.File;

public interface IVisitCallback {
    void dealWithFolder(File oFile);
    void dealWithFile(File oFile);
}
