# RandomTools
基于JavaSE图形化的随机数提取工具

* RandomMain中移除代码
```
//        while (Utils.getProperties("throwPerson").contains(value+"")){
//            value = random.nextInt(MaxPersion);
//        }
```
* 更改为
```
        for (String arr : tparr){
            while(Integer.parseInt(arr) == value){
                value = random.nextInt(MaxPersion);
            }
        }
```
* RandomMain中移除代码
```
        for (String arr : tparr){
            while(Integer.parseInt(arr) == value){
                value = random.nextInt(MaxPersion);
            }
        }
```
* 更改为
```
        if(!ThrowPerson.equals("") && " " != ThrowPerson){
            String[] tparr = Utils.getProperties("throwPerson").split(",");

            for (String arr : tparr){
                while(Integer.parseInt(arr) == value){
                    value = random.nextInt(MaxPersion);
                }
            }
        }
```