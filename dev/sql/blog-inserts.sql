USE [PORTFOLIO]
GO
SET IDENTITY_INSERT [dbo].[blog_entry] ON 

INSERT [dbo].[blog_entry] ([id], [creation_date], [modification_date], [version], [content], [tittle]) VALUES (2, NULL, NULL, 0, N'Contrary to popular belief, Lorem Ipsum is not simply random text. It has roots in a piece of classical Latin literature f', N'Testowy wpis')
INSERT [dbo].[blog_entry] ([id], [creation_date], [modification_date], [version], [content], [tittle]) VALUES (3, NULL, NULL, 0, N'Contrary to popular belief, Lorem Ipsum is not simply random text. It has roots in a piece of classical Latin literature f', N'Testowy wpis 2')
INSERT [dbo].[blog_entry] ([id], [creation_date], [modification_date], [version], [content], [tittle]) VALUES (4, NULL, NULL, 0, N'Contrary to popular belief, Lorem Ipsum is not simply random text. It has roots in a piece of classical Latin literature f', N'Testowy wpis 3')
SET IDENTITY_INSERT [dbo].[blog_entry] OFF
GO
SET IDENTITY_INSERT [dbo].[blog_comment] ON 

INSERT [dbo].[blog_comment] ([id], [creation_date], [modification_date], [version], [content], [blog_entry_id]) VALUES (1, NULL, NULL, 0, N'Komentarz 1', 2)
INSERT [dbo].[blog_comment] ([id], [creation_date], [modification_date], [version], [content], [blog_entry_id]) VALUES (2, NULL, NULL, 0, N'Komentarz 2', 2)
SET IDENTITY_INSERT [dbo].[blog_comment] OFF
GO
INSERT [dbo].[privilages] ([id], [name]) VALUES (1, N'READ_PRIVILEGE')
INSERT [dbo].[privilages] ([id], [name]) VALUES (2, N'WRITE_PRIVILEGE')
GO
INSERT [dbo].[roles] ([id], [name]) VALUES (1, N'ROLE_ADMIN')
INSERT [dbo].[roles] ([id], [name]) VALUES (2, N'ROLE_USER')
GO
INSERT [dbo].[roles_privilages] ([role_id], [privilege_id]) VALUES (1, 1)
INSERT [dbo].[roles_privilages] ([role_id], [privilege_id]) VALUES (1, 2)
INSERT [dbo].[roles_privilages] ([role_id], [privilege_id]) VALUES (2, 1)
GO
INSERT [dbo].[users] ([id], [email], [enabled], [first_name], [last_name], [password], [token_expired]) VALUES (1, N'test@test.com', 1, N'Test', N'Test', N'$2a$15$0DsNMtliPgUVfFMFxml46urpAMHk.R42jdCM3MDeWob3wh/MsGxHm', 0)
GO
INSERT [dbo].[users_roles] ([user_id], [role_id]) VALUES (1, 1)
GO
