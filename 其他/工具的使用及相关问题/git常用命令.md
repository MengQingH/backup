cd:
* git init:
* git add 文件名:暂存区添加文件，可以添加多个
* git add .  ：向暂存区添加所有更改的文件
* git commit -m"提交信息":提交修改，提交信息不能少
* git log:显示最近三次的提交日志

提交与退回：
* git reset --hard head:返回到原来的版本，git中用head代表当前版本，上个版本为head^，上上个版本为head^^，前一百个版本为head~100
* git reset --hard <版本号前几位>:退回该版本
* git reset -- <file>：把该文件从暂存区退回到工作区
* git status:查看暂存区状态
* git checkout -- 文件名：把该文件在工作区的修改全部撤销
    一是撤销工作区中的修改，把文件回退到版本库一样的状态
    二是撤销把该文件添加到暂存区之后又进行的更改，把文件退回到和暂存区中一样的内容

远程库：
* git remote add origin git@github.com:<name>/<repostory>:
* git remote add origin https://github.com:<name>/<repostory>:
* git remote add origin <address>:与远程仓库关联，关联之前需要设置SSH
* git push origin master:把修改提交到远程库
* git clone git@<地址>:把远程库中的内容克隆到本地
* git remote set-url url：切换远程库的url

分支：
* git branch:列出所有分支，当前分支前有*
* git branch <name>:创建一条新的分支
* git branch -d <name>:删除该分支
* git checkout <name>:把当前分支切换为该分支
* git merge <name>:合并指定分支到当前分支


其他：
* git remote -v:显示对应的远程库url
* git remote rm origin:移除对应的远程库
* git remote add origin url:添加一个远程库



版本库(Repository)：工作区的隐藏目录.git文件夹为git的版本库，包含暂存区和分支（master,即修改历史）以及指向分支的head。

暂存区(Stage)：存放未提交的更改，git add添加文件即把文件添加到暂存区中，git commit提交即把暂存区中的内容提交到当前分支。