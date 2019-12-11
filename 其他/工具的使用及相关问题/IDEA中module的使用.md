在idea中，一个项目为一个project，一个项目下可以有许多module，即模块，不同的模块完成不同的功能，他们之间也可以相互依赖。

## Artifact
Artifact是maven中的一个概念，表示某个module要如何打包。有war exploded、war、jar、ear等方式

## 多模块的运行
当项目中有多个模块时，需要把这些模块的Artifacts添加到运行配置中去