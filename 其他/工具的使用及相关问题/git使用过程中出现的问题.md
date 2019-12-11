## ssh: connect to host github.com port 22: Connection timed out
* 错误原因：未知
* 修改方法：把git@github.com:url连接方式改为http连接方式
    1. git remote -v查看当前远程库连接
    2. git remote rm origin移除该远程库
    3. git remote add origin url建立新的远程库，url使用http协议下的远程库url
    4. 2、3可以直接使用get remote set-url url修改远程库地址

* 修改方法2：修改本地配置把ssh连接改为https连接
    1. git config --local -e 修改本地git配置
    2. 把url从 git@github.com:username/repository 改为 https://github.com/username/repository
