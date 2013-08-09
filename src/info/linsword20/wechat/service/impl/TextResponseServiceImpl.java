package info.linsword20.wechat.service.impl;

import info.linsword20.todo.service.task.Task4WechatService;
import info.linsword20.wechat.bean.message.BaseMessage;
import info.linsword20.wechat.bean.message.TextMessage;
import info.linsword20.wechat.service.TextResponseService;

import java.util.Date;

public class TextResponseServiceImpl implements TextResponseService
{
	private final String MYID = "gh_6c458f5eba1a";
	private Task4WechatService task4WechatService;

	public Task4WechatService getTask4WechatService()
	{
		return task4WechatService;
	}

	public void setTask4WechatService(Task4WechatService task4WechatService)
	{
		this.task4WechatService = task4WechatService;
	}

	@Override
	public BaseMessage textMsgExtract(String content, String ToUserName)
	{
		TextMessage textRespMsg = new TextMessage();

		textRespMsg.setToUserName(ToUserName);
		textRespMsg.setFromUserName(MYID);
		textRespMsg.setCreateTime(new Date().getTime() + "");
		textRespMsg.setMsgType("text");
		StringBuffer stringBuffer = new StringBuffer("您好,功能开发中,谢谢");
		// 主菜单
		if ("?".equals(content) || "？".equals(content)
				|| "subscribe".equals(content))
		{
			stringBuffer.delete(0, stringBuffer.length());
			stringBuffer.append("你好,我是Jason,回复：\n");
			stringBuffer.append("1    看我的blog\n");
			stringBuffer.append("2     查看天气预报\n");
			stringBuffer.append("3     待办事项管理系统\n");

		}
		// blog使用介绍
		if ("1".equals(content))
		{
			stringBuffer.delete(0, stringBuffer.length());
			stringBuffer.append("回复blog查看我的最新blog\n");

		}
		// 天气使用介绍
		if ("2".equals(content))
		{
			stringBuffer.delete(0, stringBuffer.length());
			stringBuffer.append("回复天气+城市 查询天气信息\n");
			stringBuffer.append("如：天气北京\n");
		}
		// 天气语法错误回应
		if ("error".equals(content))
		{
			stringBuffer.delete(0, stringBuffer.length());
			stringBuffer.append("你好,木有您查询城市的天气信息\n");
			stringBuffer.append("请检查输入\n回复\"?\"获取菜单");
		}
		if ("3".equals(content))
		{
			stringBuffer.delete(0, stringBuffer.length());
			stringBuffer.append("欢迎使用待办事项管理系统\n使用方法:\n");
			stringBuffer.append("命令:task+操作+[id]+[#]+[内容]:\n");
			stringBuffer.append("检查待办: task+check\n\n");
			stringBuffer.append("添加待办: taskaddreading\n\n");
			stringBuffer.append("标记已完成: taskdone3\n\n");
			stringBuffer.append("修改某待办: taskalter4#buy pen \n\n");
			stringBuffer.append("删除某待办: taskdel3");
		}
		// 待办事项服务
		if (content.startsWith("task"))
		{
			content = content.substring(4);
			stringBuffer.delete(0, stringBuffer.length());
			// 检查待办事项
			if ("check".equals(content))
			{
				String list = this.task4WechatService.listAllTask(ToUserName);
				if (0 == list.length())
				{
					stringBuffer.append("没有待办事项！");
					
				}
				else{
				stringBuffer.append("待办事项：\n").append(list);
				}
			}

			// 删除待办事项
			else if (content.startsWith("del"))
			{
				int id = Integer.parseInt(content.substring(3));
				if (this.task4WechatService.hasTaskOfId(id))
				{
					if (this.task4WechatService.deleteTask(id, ToUserName)) stringBuffer
							.append("删除id=").append(id).append("成功!\n");
					else stringBuffer.append("id=").append(id).append("不存在!\n");
				}
				else
				{
					stringBuffer.append("id=").append(id)
							.append("待办不存在,请检查！\n");
				}
				stringBuffer.append("待办事项：\n").append(
						this.task4WechatService.listAllTask(ToUserName));

			}
			// 增加待办
			else if (content.startsWith("add"))
			{
				content = content.substring(3);
				this.task4WechatService.saveTask(content, ToUserName);
				stringBuffer.append("新增待办成功!\n");
				stringBuffer.append("待办事项：\n").append(
						this.task4WechatService.listAllTask(ToUserName));
			}
			// 标记完成
			else if (content.startsWith("done"))
			{
				int id = Integer.parseInt(content.substring(4));
				if (this.task4WechatService.hasTaskOfId(id))
				{
					if (this.task4WechatService.markTask(id, ToUserName)) stringBuffer
							.append(this.task4WechatService.findById(id))
							.append("(id=").append(id).append(")事件完成!\n");
					else stringBuffer.append("id=").append(id).append("不存在!\n");
				}
				else
				{
					stringBuffer.append("id=").append(id)
							.append("待办不存在,请检查！\n");
				}
				stringBuffer.append("待办事项：\n").append(
						this.task4WechatService.listAllTask(ToUserName));
			}
			// 修改待办
			else if (content.startsWith("alter"))
			{
				content = content.substring(5);
				String[] tmp =
				{ "", "" };
				if (content.contains("#") && !content.startsWith("#"))
				{
					tmp = content.split("#");

					int id = Integer.parseInt(tmp[0]);
					content = tmp[1];
					if (this.task4WechatService.hasTaskOfId(id))
					{
						if (this.task4WechatService.updateTask(id, ToUserName,
								content))
						{
							stringBuffer.append("修改待办:\"").append(content)
									.append("\"保存成功!\n");
						}
						else stringBuffer.append("id=").append(id).append(
								"不存在!\n");
					}
					else
					{
						stringBuffer.append("id=").append(id).append(
								"待办不存在,请检查！\n");
					}
					stringBuffer.append("待办事项：\n").append(
							this.task4WechatService.listAllTask(ToUserName));
				}
				else
				{
					stringBuffer.append("您好,请检查您的输入,谢谢\n");
					stringBuffer.append("修改待办: taskalter4#buy\n\n");
					stringBuffer.append("回复\"3\"获取命令帮助\n");
					stringBuffer.append("回复\"?\"获取主菜单");
				}

			}
			// Task系统语法错误回应
			else
			{
				stringBuffer.append("您好,请检查您的输入,谢谢\n");
				stringBuffer.append("回复\"3\"获取命令帮助\n");
				stringBuffer.append("回复\"?\"获取主菜单");
			}

		}
		textRespMsg.setContent(stringBuffer.toString());
		return textRespMsg;
	}
}
