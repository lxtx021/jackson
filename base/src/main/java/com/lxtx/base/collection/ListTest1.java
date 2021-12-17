package com.lxtx.base.collection;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author 孙洪波
 * @version 1.0
 * @description
 * @date 2020/11/23
 **/
public class ListTest1 {
    public static void main(String[] args) {
        String str="直接原因\n" +
                "1.据监控显示，11:33邓某将平台车桥平台降至最低；关闭货舱门前，邓某根据陈某站立抬手后与飞机舱门控制面板的距离高度，重新升高了桥平台高度，陈某伸手操作舱门开关。据向当事人陈某了解其身高1.67米，如不升高桥平台将无法触及舱门开关。因此，驾驶员邓某将桥平台升高后便于陈某能够触及货舱门开关，但未确认升高后的高度是否满足与货舱门关闭的安全距离。\n" +
                "2.装卸员陈某操作舱门关闭前，未征得驾驶员邓某同意，违反了《B货站站坪、行车作业指导书》“装卸人员应仔细观察舱门左右是否有障碍物并征得平台车驾驶员同意，才开始下降货舱门”规定。同时陈某也未提醒驾驶员邓某按作业手册要求到另一侧目测观察货舱门运行轨迹。\n" +
                "3.驾驶员邓某在舱门已处于关闭过程时，未按《成都货站站坪、行车作业指导书》规定的“当舱门下降到一定高度时，平台车驾驶员和装卸人员应目测桥平台是否阻碍货舱门下降，确认货舱门和桥平台不会擦挂，才能继续下降货舱门，直至关闭。”进行规范作业。\n" +
                "通过以上分析，说明装卸员陈某、驾驶员邓某违反了《B货站站坪、行车作业指导书》关于开关舱门的操作规程。驾驶员在舱门关闭过程中，未对前舱门另一侧进行目测观察，无法发现舱门可能与桥平台发生刮碰，属于典型的违章操作。\n" +
                "（二）系统原因\n" +
                "    1.涉及高风险工种特种车驾驶员的业务能力培训及上岗考核标准制度缺失 \n" +
                "B货站规定了员工持证上岗的一般要求，但未颁发上岗证，均以培训考核评价意见作为上岗资质。\n" +
                "2.执行手册缺乏操作性\n" +
                "（1）货舱门关闭前，为保证装卸人员能够正常操作，《B货站升降平台车操作规程》规定“平台车驾驶员应在舱门下降之前，把桥平台下降到一定的高度”，实际操作过程中，下降高度由驾驶员根据经验主观判断，存在因桥平台的高度过高与关闭舱门发生刮碰的风险。\n" +
                "（2）货舱关闭过程中，《B货站升降平台车操作规程》规定“当舱门下降到一定高度时，平台车驾驶员和装卸人员应目测桥平台是否阻碍货舱门下降，确认货舱门和桥平台不会擦挂”，操作规程未明确规定人员目测确认时舱门下降高度的范围值或具体应该下降至什么高度，如果舱门底部距桥平台较高时，作业人员无法准确目测判断是否会刮碰；如果舱门继续下降过半后，即使平台车操作人员观察到有刮蹭风险，也无法确保立即将停止关闭舱门的指令传达给装卸人员。\n" +
                "3.开关舱门的风险管控措施不佳\n" +
                "（1）B货站已将“开关舱门过程中舱门与平台车发生擦刮”的风险识别为三级危险源管理，但制定的控制措施缺乏可操作性，其制定措施即为《平台车操作规程》第3.6条：“当飞机货舱门关闭时，平台车驾驶员应在舱门下降之前，把桥平台下降到一定高度，装卸人员应仔细观察舱门左右是否有障碍物并征得到平台车驾驶员同意，才开始下降货舱门，当舱门下降到一定高度时，平台车驾驶员和装卸人员应目测桥平台是否阻碍货舱门下降，桥平台在下降过程中，严禁装卸人员操作货舱门下降，直到确认货舱门不会和桥平台擦挂，才允许货舱门关闭。”此项措施在上一分析中已经阐述其弊端，因此不能达到降低风险的效果。\n" +
                "（2）B货站未就所保障的不同机型货的舱门操作面板高度不一情况，可能因为操作人员自身身高条件限制等因素，对作业人员利用平台车升降高度操作飞机货舱门开关的风险进行识别并做好系统性分析、评估，从而制定安全可靠且具有实际可操作性的风险控制措施。\n";
        int a =StringUtils.length(str);
        System.out.println(a);
        System.out.println(str.length());


//        testIterator();
    }

    public static void testFor(){
        List<String> platformList = new ArrayList<>();
        platformList.add("博客园");
        platformList.add("CSDN");
        platformList.add("掘金");
        // for 循环迭代
        for (int i = 0; i < platformList.size(); i++) {
            String item = platformList.get(i);
            if (item.equals("博客园")) {
                platformList.remove(i);
                i = i - 1;
            }
        }
        System.out.println(platformList);
    }

    public static void testIterator(){
        List<String> platformList = new ArrayList<>();
        platformList.add("博客园");
        platformList.add("CSDN");
        platformList.add("掘金");
        Iterator<String> iterator = platformList.iterator();
        while (iterator.hasNext()) {
            String platform = iterator.next();
            if (platform.equals("博客园")) {
                iterator.remove();
            }
        }
        System.out.println(platformList);
    }
}
