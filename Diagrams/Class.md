# Document Generation Service - Диаграмма классов

## Диаграмма
![Class Diagram](images/class.png)

## Глоссарий

| Класс | Атрибуты | Методы | Описание |
|-------|----------|---------|-----------|
| IdentifiableEntity | - id: String<br>- createdAt: DateTime<br>- updatedAt: DateTime | + getId(): String<br>+ getCreatedAt(): DateTime<br>+ getUpdatedAt(): DateTime | Абстрактный базовый класс с общими полями идентификации |
| User | - username: String<br>- email: String<br>- passwordHash: String<br>- isActive: Boolean | + createProject(): Project<br>+ manageTemplate(): Boolean<br>+ authenticate(): Boolean<br>+ deactivate(): void | Представляет пользователя системы |
| Project | - name: String<br>- description: String<br>- isArchived: Boolean | + addTemplate(): DocumentTemplate<br>+ archive(): void<br>+ getTemplates(): List<DocumentTemplate> | Контейнер для организации шаблонов документов |
| DocumentTemplate | - name: String<br>- content: String<br>- fileFormat: String<br>- version: Integer | + addField(): void<br>+ validateData(): Boolean<br>+ generateDocument(): DocumentInstance<br>+ getFields(): List<TemplateField> | Определяет структуру и содержание шаблонов документов |
| TemplateField | - name: String<br>- type: String<br>- isRequired: Boolean<br>- validationRule: String<br>- defaultValue: String | + validate(): Boolean<br>+ getType(): String | Представляет переменное поле в шаблоне документа |
| DocumentInstance | - fileName: String<br>- filePath: String<br>- status: DocumentStatus<br>- fileSize: Long<br>- generatedAt: DateTime | + download(): byte[]<br>+ getInfo(): DocumentInfo<br>+ delete(): Boolean | Представляет сгенерированный экземпляр документа |
| GenerationSession | - status: SessionStatus<br>- inputData: Map<String, Object><br>- startedAt: DateTime<br>- completedAt: DateTime<br>- errorMessage: String | + executeGeneration(): DocumentInstance<br>+ cancel(): Boolean<br>+ getProgress(): Integer | Отслеживает процесс генерации документа |

## Перечисления

| Перечисление | Значения | Описание |
|--------------|-----------|-----------|
| DocumentStatus | GENERATING, COMPLETED, FAILED, DELETED | Статусы генерации документа |
| SessionStatus | PENDING, IN_PROGRESS, COMPLETED, FAILED, CANCELLED | Статусы сессии генерации |

## Взаимосвязи

| Связь | Тип | Описание |
|-------|-----|-----------|
| User → Project | Композиция (1..*) | Пользователь владеет проектами |
| User → DocumentInstance | Композиция (1..*) | Пользователь владеет документами |
| Project → DocumentTemplate | Композиция (1..*) | Проект содержит шаблоны |
| DocumentTemplate → TemplateField | Композиция (1..*) | Шаблон состоит из полей |
| DocumentTemplate → DocumentInstance | Ассоциация (1..*) | Шаблон генерирует документы |
| DocumentTemplate → GenerationSession | Ассоциация (1..*) | Шаблон используется в сессиях |
| GenerationSession → DocumentInstance | Ассоциация (1..*) | Сессия производит документы |
| IdentifiableEntity → Наследники | Наследование | Базовый класс для всех сущностей |