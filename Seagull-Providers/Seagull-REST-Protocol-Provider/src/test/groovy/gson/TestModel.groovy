package gson

import se.natusoft.tools.modelish.Model

// Modelish model
interface TestModel extends  Model<TestModel>{

    void setName(String name)
    String getName()

    void setDecimal(Float decimal)
    double getDecimal()

    void setBool(boolean bool)
    boolean getBool()
}
